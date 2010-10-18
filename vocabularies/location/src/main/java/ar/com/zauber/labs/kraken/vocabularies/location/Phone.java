/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location;

import org.openrdf.elmo.annotations.rdf;

/**
 * Representa un numero de telefono.
 *
 * @author Mariano Semelman
 * @since Nov 24, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_PHONE)
public interface Phone  extends Topic {

    /** @return numero de telefono */
    @rdf(value = {
            LocationNamespaceUtils.PHONE_NUMBER, 
            "http://purl.org/dc/elements/1.1/title"
        })
    String getNumber();
}
