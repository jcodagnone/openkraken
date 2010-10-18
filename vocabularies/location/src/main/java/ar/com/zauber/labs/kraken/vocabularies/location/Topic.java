/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location;

import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

/**
 * Topico en general
 * 
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_TOPIC)
public interface Topic {

    /** @return nombre representativo */
    @rdf(LocationNamespaceUtils.TOPIC_NAME)
    @localized
    String getTitle();
}
