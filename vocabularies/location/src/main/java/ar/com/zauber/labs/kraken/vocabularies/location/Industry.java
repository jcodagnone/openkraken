/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

/**
 * Tipo de  industria (Ej: "bar")
 * 
 * @author Marcelo Turrin
 * @since Nov 6, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_INDUSTRY)
public interface Industry  extends Topic {
    
    /** @return todas los locales que tienen como industria primaria a esta */
    @inverseOf(LocationNamespaceUtils.BUSINESS_LOCATION_PRIMARY_INDUSTRY)
    Set<BusinessLocation> getPrimaryBusinessLocations();
    
    /** @return todas los locales que tienen como industria secundaria a esta */
    @inverseOf(LocationNamespaceUtils.BUSINESS_LOCATION_SECUNDARY_INDUSTRY)
    Set<BusinessLocation> getSecundaryBusinessLocations();
}