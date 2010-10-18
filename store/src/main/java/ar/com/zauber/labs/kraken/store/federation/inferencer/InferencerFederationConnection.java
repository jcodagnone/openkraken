/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.store.federation.inferencer;

import java.util.List;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.sail.NotifyingSailConnection;
import org.openrdf.sail.SailConnectionListener;
import org.openrdf.sail.SailException;
import org.openrdf.sail.federation.Federation;
import org.openrdf.sail.inferencer.InferencerConnection;

import ar.com.zauber.labs.kraken.store.federation.FederationConnection;
import ar.com.zauber.labs.kraken.store.federation.ReadOnlyConnection;

/**
 * {@link FederationConnection} que implementa {@link InferencerConnection}.
 * Mantiene una referencia otra {@link InferencerConnection} a la que se
 * redirigirán los pedidos relacionados con altas y bajas de statements
 * inferidos. Es por esto que la conexión a la {@link Federation} siendo
 * readOnly (extiende de {@link ReadOnlyConnection}).
 * 
 * @author Francisco J. González Costanzó
 * @since Dec 16, 2009
 */
public class InferencerFederationConnection extends ReadOnlyConnection 
                    implements InferencerConnection {

    private final InferencerConnection inferencerConnection;

    /**
     * Creates the InferencerFederationConnection.
     * @param federationConnection
     * @param inferencesRepository
     */
    public InferencerFederationConnection(final Federation federation, 
            final List<RepositoryConnection> members,
            final InferencerConnection inferencerConnection) {
        super(federation, members);
        this.inferencerConnection = inferencerConnection;
    }

    /** @see InferencerConnection#addInferredStatement(Resource, URI, Value, 
     *             Resource[]) */
    public final boolean addInferredStatement(final Resource subj, final URI pred, 
            final Value obj, final Resource... contexts) throws SailException {
        //FIXME
        inferencerConnection.addStatement(subj, pred, obj, contexts);
        inferencerConnection.commit();
        return true;
    }

    /** @see InferencerConnection#clearInferred(Resource[]) */
    public final void clearInferred(final Resource... contexts)
            throws SailException {
        inferencerConnection.clearInferred(contexts);
    }

    /** @see InferencerConnection#flushUpdates() */
    public final void flushUpdates() throws SailException {
        inferencerConnection.flushUpdates();
    }

    /** @see InferencerConnection#removeInferredStatement(Resource, URI, Value, 
     *          Resource[]) */
    public final boolean removeInferredStatement(final Resource subj, 
            final URI pred, final Value obj, final Resource... contexts) 
            throws SailException {
        //FIXME
        inferencerConnection.removeStatements(subj, pred, obj,
                contexts);
        inferencerConnection.commit();
        return true;
    }

    /** @see NotifyingSailConnection#addConnectionListener(SailConnectionListener) */
    public final void addConnectionListener(final SailConnectionListener listener) {
        inferencerConnection.addConnectionListener(listener);
    }

    /** @see NotifyingSailConnection#removeConnectionListener(
     *          SailConnectionListener) */
    public final void removeConnectionListener(
            final SailConnectionListener listener) {
        inferencerConnection.removeConnectionListener(listener);
    }
}