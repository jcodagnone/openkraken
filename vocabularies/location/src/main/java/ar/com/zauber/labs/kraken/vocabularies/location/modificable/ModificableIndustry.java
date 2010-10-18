/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Industry;
import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/**
 * Modificable {@link Industry}
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_INDUSTRY)
public interface ModificableIndustry extends Industry, ModificableTopic {
    
}
