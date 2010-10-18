/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location;

import java.util.Set;

import org.openrdf.elmo.annotations.disjointWith;
import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

/**
 * Company
 * 
 * @author Marcelo Turrin
 * @since Nov 6, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_COMPANY)
@disjointWith(value = {Location.class, BusinessLocation.class, Industry.class })
public interface Company extends Topic {

    /** @return el cuit de la empresa */
    @rdf(LocationNamespaceUtils.COMPANY_CUIT)
    String getCuit();

    
    /** las {@link BusinessLocation} de una empresa */
    @inverseOf(LocationNamespaceUtils.BUSINESS_LOCATION_OWNER_BY)
    Set<BusinessLocation> getBusinessLocations();
}