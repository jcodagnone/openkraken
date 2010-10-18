/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Location;


/**
 * Location que tiene información especifica del catastro de buenos aires.
 * 
 * @author Juan F. Codagnone
 * @since Nov 19, 2009
 */
@rdf(NamespaceUtils.TYPE_BUE_LOCATION)
public interface BuenosAiresLocation extends Location {
    /** @return la manzana donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_BLOCK)
    String getBlock();

    /** @return la sección donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_SECTION)
    Integer getSection();

    /** @return la parcela donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_LOT)
    String getLot();
    
    /** @return el codigo de puerta de donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_DOORCODE)
    Integer getDoorCode();
}
