/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.Company;
import ar.com.zauber.labs.kraken.vocabularies.location.Industry;
import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/**
 * {@link BusinessLocation} que es modificable (para carga)
 * 
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_BUSINESS_LOCATION)
public interface ModificableBusinessLocation extends BusinessLocation, 
                                                     ModificableLocation {


    /** @see BusinessLocation#getCompany() */
    void setCompany(Company company);

    /** @see BusinessLocation#getIndustry() */
    void setIndustry(Industry industry);

    /** @see BusinessLocation#getSecundaryIndustry() */
    void setSecundaryIndustry(Industry industry);
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @return la compania del {@link BusinessLocation} */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_OWNER_BY)
    Company getCompany();

    /** @return el rubro del del {@link BusinessLocation} */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_PRIMARY_INDUSTRY)
    Industry getIndustry();

    /** @return el rubro secundario (puede ser nulo) */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_SECUNDARY_INDUSTRY)
    Industry getSecundaryIndustry();
}
