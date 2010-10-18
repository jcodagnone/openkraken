/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Industry;

/**
 * {@link Industry} en sali seguro
 * 
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */
@rdf(NamespaceUtils.TYPE_SALI_SEGURO_INDUSTRY)
public interface SaliSeguroIndustry extends Industry {

    /** @return el identificador de este rubro */
    @rdf(NamespaceUtils.INDUSTRY_ID)
    long getId();
    
}
