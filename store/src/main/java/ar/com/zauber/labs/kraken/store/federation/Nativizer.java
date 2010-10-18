/**
 * Copyright (c) 2009-2010 Zauber S.A. <http://www.zauber.com.ar/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.com.zauber.labs.kraken.store.federation;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.lang.UnhandledException;
import org.apache.commons.lang.Validate;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManagerFactory;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFWriter;
import org.openrdf.rio.RDFWriterRegistry;
import org.openrdf.sail.nativerdf.NativeStore;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * Clase de utilidad para traer un monton de repos externos a un solo repositorio
 * local en el disco.
 *
 * @author Mariano Semelman
 * @since Jan 6, 2010
 */
public final class Nativizer implements FactoryBean<SesameManagerFactory>,
DisposableBean {

    private final SesameManagerFactory managerFactory;
    private final File dataDir;


    /** constructor que recibe uris para
     * @param urls */
    public Nativizer(final List<String> urls) {
        this(urls, new File("./target/data/"));
    }
    /** Creates the Nativizer.
     * @param urls
     * @param file */
    public Nativizer(final List<String> urls, final File file) {
        Validate.notNull(file);
        Validate.noNullElements(urls);

        this.dataDir = file;
        this.managerFactory = nativize(urls);
    }
    /** federa todos estos repositorios de forma nativa (de forma local)
     * @return  el managerFactory que administra el repositorio local */
    private SesameManagerFactory nativize(final List<String> urls) {
        final SesameManagerFactory sesameManagerFactory =
            new SesameManagerFactory(new ElmoModule(), getSailRepository());
        sesameManagerFactory.setInferencingEnabled(true);
        final Repository diskRepo = sesameManagerFactory.getRepository();

        /* por cada repo externo copio su contenido al local */
        for (final String url : urls) {
            importStatements(diskRepo, url);
        }
        return sesameManagerFactory;
    }
    /**
     * dada una url y un repo local, vuelva todo el contenido del repositorio en
     * esa url al repolocal.
     * @param diskRepo
     * @param url
     */
    private  void importStatements(final Repository diskRepo,
            final String url) {
        final Repository remoteRepo = new HTTPRepository(url);
        final StringWriter writer = new StringWriter();
        final RDFWriter rdfWriter = RDFWriterRegistry.getInstance()
            .get(RDFFormat.TURTLE).getWriter(writer);
        RepositoryConnection conn = null;
        RepositoryConnection remoteconn = null;
        try {
                conn = diskRepo.getConnection();
                remoteconn = remoteRepo.getConnection();

            try {
                /* exporto el remoto y lo agrego al local */
                remoteconn.export(rdfWriter);
                conn.add(new StringReader(writer.toString()),
                        "", RDFFormat.TURTLE);
                conn.commit();
            } catch (final Exception e) {
                throw new UnhandledException("Error al importar rdf", e);
            }
        } catch (final RepositoryException e1) {
            throw new UnhandledException("no se pudo conectar al repositorio",
                    e1);
        } finally {
            try {
                if(remoteconn != null) {
                    remoteconn.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (final RepositoryException e) { /**/ }
        }
    }
    /** crea un repositorio en disco */
    private SailRepository getSailRepository() {
        final SailRepository sailRepository = new SailRepository(
                getSailConfiguration());
        try {
            sailRepository.initialize();
        } catch (final RepositoryException e2) {
            throw new UnhandledException("error inicializando el repo local", e2);
        }
        /* me aseguro que se haya creado de forma correcta */
        Validate.notNull(sailRepository.getValueFactory(),
                "Error creando repo local");
        return sailRepository;
    }
    /** crea una configuracion sail */
    private NativeStore getSailConfiguration() {
        final NativeStore sail = new NativeStore(getDatadir());
        /* defino indices standards */
        sail.setTripleIndexes("spoc, posc");
        return sail;
    }
    /**
     * @return
     */
    private File getDatadir() {
        if(!dataDir.exists()) {
            /* creo la carpeta */
            Validate.isTrue(dataDir.mkdirs(), "error al crear la carpeta"
                    + dataDir.toString());
        } else {
            borrarContenido(dataDir);
        }
        return dataDir;
    }
    /**
     * @param carpeta
     */
    private void borrarContenido(final File carpeta) {
        if (new File(carpeta.toString() + "lock").exists()) {
            throw new RuntimeException("nativo actualmente en uso, no"
                    + "se pude hacer clean de este archivo: "
                    + carpeta.listFiles()[0].toString());
        }
        /* borro todo lo que contiene esta carpeta */
        while(carpeta.listFiles().length > 0) {
            if(!carpeta.listFiles()[0].delete()) {
                /* si existe una carpeta (probablemente "lock") se detiene
                 * por que ya existe un repo local.*/
                throw new RuntimeException("nativo actualmente en uso, no"
                        + "se pude hacer clean de este archivo: "
                        + carpeta.listFiles()[0].toString());
            }
        }
    }
    /** @see org.springframework.beans.factory.FactoryBean#getObject() */
    public SesameManagerFactory getObject() throws Exception {
        return this.managerFactory;
    }
    /** @see org.springframework.beans.factory.FactoryBean#getObjectType() */
    public Class<? extends SesameManagerFactory> getObjectType() {
        return SesameManagerFactory.class;
    }
    /** @see org.springframework.beans.factory.FactoryBean#isSingleton() */
    public boolean isSingleton() {
        return true;
    }
    /** @see org.springframework.beans.factory.DisposableBean#destroy() */
    public void destroy() throws Exception {
        this.managerFactory.close();
        try {
            this.managerFactory.getRepository().shutDown();
        } catch (final RepositoryException e) {
            throw new UnhandledException("no se pudo apagar el repo", e);
        }
        borrarContenido(this.dataDir);
    }

}
