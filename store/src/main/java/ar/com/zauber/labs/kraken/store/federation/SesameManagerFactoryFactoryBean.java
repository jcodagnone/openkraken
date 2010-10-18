/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.store.federation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.Validate;
import org.openrdf.elmo.ElmoManagerFactory;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManagerFactory;
import org.openrdf.query.QueryLanguage;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.sail.SailException;
import org.openrdf.sail.config.SailConfigException;
import org.openrdf.sail.federation.Federation;
import org.openrdf.sail.inferencer.fc.ForwardChainingRDFSInferencer;
import org.openrdf.sail.nativerdf.NativeStore;
import org.springframework.beans.factory.FactoryBean;

import ar.com.zauber.labs.kraken.store.federation.inferencer.InferencerFederation;

/**
 * Factory de {@link SesameManagerFactory}
 * 
 * @author Francisco J. González Costanzó
 * @since Nov 26, 2009
 */
public class SesameManagerFactoryFactoryBean 
  implements FactoryBean<ElmoManagerFactory> {
    private final SesameManagerFactory factory;
    
    /** @param urls lista de URLs de los repositorios que se quieren federar */ 
    public SesameManagerFactoryFactoryBean(final List<String> urls) 
       throws RepositoryException, SailConfigException, SailException,
              MalformedURLException {
        this(urls, new ElmoModule(), null);
    }
    
    /** @param urls lista de URLs de los repositorios que se quieren federar 
     *  @param inferencesRepository repo para inferencias
     **/ 
    public SesameManagerFactoryFactoryBean(final List<String> urls,
            final SailRepository inferencesRepository) 
       throws RepositoryException, SailConfigException, SailException, 
              MalformedURLException {
        this(urls, new ElmoModule(), inferencesRepository);
    }    
    
    /** @param urls lista de URLs de los repositorios que se quieren federar
     *  @param elmoModule a usar en el constructor
     **/  
    public SesameManagerFactoryFactoryBean(final List<String> urls, 
            final ElmoModule elmoModule) throws RepositoryException, 
             SailConfigException, SailException, MalformedURLException {
        this(urls, Collections.EMPTY_LIST, elmoModule, null);
    }
    
    /** @param urls lista de URLs de los repositorios que se quieren federar 
     *  @param elmoModule a usar en el constructor
     *  @param inferencesRepository repo para inferencias
     **/  
    public SesameManagerFactoryFactoryBean(final List<String> urls, 
            final ElmoModule elmoModule, final SailRepository inferencesRepository) 
            throws RepositoryException, 
             SailConfigException, SailException, MalformedURLException {
        this(urls, Collections.EMPTY_LIST, elmoModule, inferencesRepository);
    }
    
    /** @param urls lista de URLs de los repositorios que se quieren federar  
     *  @param repositories repos a agregar a la federacion
     *  @param elmoModule a usar en el constructor 
     **/
    public SesameManagerFactoryFactoryBean(final List<String> urls,
            final List<Repository> repositories,
            final ElmoModule elmoModule) 
           throws RepositoryException, SailConfigException, SailException, 
                  MalformedURLException {
        this(urls, repositories, elmoModule, null);
    }
    
    /** @param urls lista de URLs de los repositorios que se quieren federar  
     *  @param repositories repos a agregar a la federacion
     *  @param elmoModule a usar en el constructor
     *  @param inferencesRepository repo para inferencias 
     */
    public SesameManagerFactoryFactoryBean(final List<String> urls,
            final List<Repository> repositories,
            final ElmoModule elmoModule,
            final SailRepository inferencesRepository) 
           throws RepositoryException, SailConfigException, SailException,
                  MalformedURLException {
        Validate.noNullElements(urls);
        Validate.notNull(elmoModule);
        
        factory = new SesameManagerFactory(
                elmoModule, getRepository(urls, repositories, inferencesRepository));
        factory.setInferencingEnabled(true);
        factory.setQueryLanguage(QueryLanguage.SPARQL);
    }    
    
    /** Retorna un repositorio (federado, remoto, o solito) */
    public static Repository getRepository(final List<String> urls, 
            final List<Repository> repositories, 
            final SailRepository inferencesRepository)
            throws RepositoryException, SailConfigException, SailException, 
                   MalformedURLException {
        Repository ret;
        
        if (inferencesRepository == null) {
            if(urls.size() + repositories.size() == 1) {
                if(urls.size() == 1) {
                    ret = createRepository(new URL(urls.iterator().next()));
                    ret.initialize();
                } else {
                    ret = repositories.iterator().next();
                }
            } else {
                ret = getFederationRepository(urls, repositories);
            }
        } else {
            ret = getInferencerFederationRepository(
                    urls, repositories, inferencesRepository);
        }
        
        return ret;
    }
    
    private static final Set<String> PROTOCOLS = new TreeSet<String>(
            Arrays.asList("http", "https"));

    /** crea el repositorio  */
    private static Repository createRepository(final URL url) 
            throws RepositoryException {
        final String proto = url.getProtocol().toLowerCase();
        Repository repo;
        if(proto.equals("http") || proto.equals("https")) {
            repo = new HTTPRepository(url.toExternalForm());
        } else if(proto.equals("file"))  {
            repo = new SailRepository(new ForwardChainingRDFSInferencer(
                    new NativeStore(new File(url.getPath()), "spoc,posc")));
        } else {
            throw new IllegalStateException("Unknown protocol " + proto);
        }
        return repo;
    }
    
    /**
     * Devuelve un {@link Repository} que federa a todos los repositorios
     * remotos de las URLs indicadas
     * @param repositories 
     */
    private static Repository getFederationRepository(final List<String> urls, 
                final List<Repository> repositories)
                throws RepositoryException, SailConfigException, SailException, 
                       MalformedURLException {
        // Creo el fed
        final Federation sail = new Federation();
        sail.setReadOnly(true);
        sail.setDistinct(false);

        for(final String url : urls) {
            sail.addMember(createRepository(new URL(url)));
        }
        for(final Repository repo : repositories) {
            sail.addMember(repo);
        }

        final Repository fedRepo = new SailRepository(sail);
        fedRepo.initialize();
        return fedRepo;
    }
    
    /**
     * Devuelve un {@link Repository} que federa a todos los repositorios
     * remotos de las URLs indicadas, con soporte para inferencias
     * @param repositories 
     */
    public static Repository getInferencerFederationRepository(
            final List<String> urls, 
            final List<Repository> repositories,
            final SailRepository inferencesRepository)
            throws RepositoryException, SailConfigException, SailException, 
                   MalformedURLException {
        // Creo el fed
        final InferencerFederation sail = new InferencerFederation(
                inferencesRepository);
        sail.setReadOnly(true);
        sail.setDistinct(false);

        for(final String url : urls) {
            sail.addMember(createRepository(new URL(url)));
        }
        for(final Repository repo : repositories) {
            sail.addMember(repo);
        }
        
        final Repository fedRepo = new SailRepository(sail);
        fedRepo.initialize();
        return fedRepo;
    }    

    
    /** @see FactoryBean#getObject() */
    public final SesameManagerFactory getObject() throws Exception {
        return factory;
    }

    /** @see FactoryBean#getObjectType() */
    public final Class<? extends ElmoManagerFactory> getObjectType() {
        return ElmoManagerFactory.class;
    }

    /** @see FactoryBean#isSingleton() */
    public final boolean isSingleton() {
        return true;
    }
}
