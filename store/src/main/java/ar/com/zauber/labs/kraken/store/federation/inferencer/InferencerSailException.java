/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.store.federation.inferencer;

import org.openrdf.sail.SailException;

/**
 * Excepciones relacionadas con {@link InferencerFederation}
 * 
 * @author Francisco J. González Costanzó
 * @since Dec 17, 2009
 */
public class InferencerSailException extends SailException {

    /** <code>serialVersionUID</code> */
    private static final long serialVersionUID = -7865270129199975984L;

    /** Creates the InferencerSailException. */
    public InferencerSailException() {
        super();
    }
    
    /** Creates the InferencerSailException. */
    public InferencerSailException(final Throwable t) {
        super(t);
    }
    
    /** Creates the InferencerSailException. */
    public InferencerSailException(final String msg) {
        super(msg);
    }
    
    /** Creates the InferencerSailException. */
    public InferencerSailException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
