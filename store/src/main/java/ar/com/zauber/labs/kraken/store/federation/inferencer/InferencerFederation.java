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
package ar.com.zauber.labs.kraken.store.federation.inferencer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.UnhandledException;
import org.apache.commons.lang.Validate;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.repository.sail.SailRepositoryConnection;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;
import org.openrdf.sail.federation.Federation;
import org.openrdf.sail.inferencer.InferencerConnection;

/**
 * {@link Federation} que provee soporte para inferencias.
 * 
 * @author Francisco J. González Costanzó
 * @since Dec 16, 2009
 */
public class InferencerFederation extends Federation {
    private final SailRepository inferencesRepository;
    private final List<Repository> members = new ArrayList<Repository>();
    
    /** @param inferenceRepository repositorio donde se almacenan */
    public InferencerFederation(final SailRepository inferenceRepository) {
        Validate.notNull(inferenceRepository, "inference repository can't be null");
        
        this.inferencesRepository =  inferenceRepository;
        addMember(inferenceRepository);
    }
    
    /**
     * Proxy de {@link Federation#addMember(Repository)} para poder mantener 
     * una referencia propia a los miembros.
     * 
     * @see Federation#addMember(Repository)
     */
    @Override
    public final void addMember(final Repository member) {
        members.add(member);
        super.addMember(member);
    }
    
    /** @see Federation#getConnectionInternal() */
    @Override
    protected final SailConnection getConnectionInternal() throws SailException {
        SailConnection inferencerConnection = null;
        SailRepositoryConnection repoConnection = null;
        
        try {
            repoConnection = inferencesRepository.getConnection();
            inferencerConnection = repoConnection.getSailConnection();
            
            final List<RepositoryConnection> connections = 
                new ArrayList<RepositoryConnection>(members.size());
            for (Repository member : members) {
                connections.add(member.getConnection());
            }
            
            return new InferencerFederationConnection(this, connections, 
                (InferencerConnection) inferencerConnection);    
        } catch (RepositoryException e) {
            throw new InferencerSailException(e);
        } catch (ClassCastException e) {
            throw new InferencerSailException(e);
        }
    }
}
