/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;


/**
 * Define a un "local" de una compañia
 *
 * @author Marcelo Turrin
 * @since Nov 5, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_BUSINESS_LOCATION)
public interface BusinessLocation extends Location {

    /** @return la compania del {@link BusinessLocation} */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_OWNER_BY)
    Company getCompany();

    /** @return el rubro del del {@link BusinessLocation} */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_PRIMARY_INDUSTRY)
    Industry getIndustry();

    /** @return el rubro secundario (puede ser nulo) */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_SECUNDARY_INDUSTRY)
    Industry getSecundaryIndustry();

    /** @return el teléfono de este lugar */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_PHONE)
    Set<Phone> getPhone();
}