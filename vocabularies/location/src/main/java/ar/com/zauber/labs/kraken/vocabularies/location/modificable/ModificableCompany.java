/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.Company;
import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/**
 * Compania modificable
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_COMPANY)
public interface ModificableCompany extends Company, ModificableTopic {

    /** @see Company#getCuit() */
    void setCuit(String cuit);

    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @return el cuit de la empresa */
    @rdf(LocationNamespaceUtils.COMPANY_CUIT)
    String getCuit();

    /** las {@link BusinessLocation} de una empresa */
    @inverseOf(LocationNamespaceUtils.BUSINESS_LOCATION_OWNER_BY)
    Set<BusinessLocation> getBusinessLocations();
}
