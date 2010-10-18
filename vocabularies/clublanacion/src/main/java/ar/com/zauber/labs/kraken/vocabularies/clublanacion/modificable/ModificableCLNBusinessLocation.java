/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.clublanacion.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNBenefit;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNNamespaceUtils;

/**
 * Business location de la nacion modificable (fines de test)
 *
 * @author Mariano Semelman
 * @since Dec 1, 2009
 */
@rdf(CLNNamespaceUtils.TYPE_LOCATION)
public interface ModificableCLNBusinessLocation extends CLNBusinessLocation {

    /** setea el id */
    @rdf(CLNNamespaceUtils.CLN_BUSINESS_LOCATION_ID)
    void setId(long id);

    //XXX elmo bug
    /** @return el id dentro de la nacion de este business location */
    @rdf(CLNNamespaceUtils.CLN_BUSINESS_LOCATION_ID)
    long getId();

    /** @return los benficios que tiene este negocio */
    @rdf(CLNNamespaceUtils.CLN_TYPE_BENEFIT)
    Set<CLNBenefit> getCLNBenefits();
}
