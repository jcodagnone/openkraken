/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location.modificable;

import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.location.Topic;

/**
 * Modificable {@link Topic}
 * 
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_TOPIC)
public interface ModificableTopic extends Topic {

    /** @see Topic#getName() */
    void setTitle(String name);
    
    // DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) ///
    /** @return nombre representativo */
    @rdf(LocationNamespaceUtils.TOPIC_NAME)
    @localized
    String getTitle();
}
