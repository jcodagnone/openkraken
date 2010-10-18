/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Location;


/**
 * Location que tiene informaci�n especifica del catastro de buenos aires.
 * 
 * @author Juan F. Codagnone
 * @since Nov 19, 2009
 */
@rdf(NamespaceUtils.TYPE_BUE_LOCATION)
public interface BuenosAiresLocation extends Location {
    /** @return la manzana donde est� el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_BLOCK)
    String getBlock();

    /** @return la secci�n donde est� el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_SECTION)
    Integer getSection();

    /** @return la parcela donde est� el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_LOT)
    String getLot();
    
    /** @return el codigo de puerta de donde est� el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_DOORCODE)
    Integer getDoorCode();
}
