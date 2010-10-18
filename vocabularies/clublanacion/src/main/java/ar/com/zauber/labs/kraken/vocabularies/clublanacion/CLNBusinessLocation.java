/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.clublanacion;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;

/**
 *  modelo de un {@link BusinessLocation} de club la nacion.
 *
 * @author Mariano Semelman
 * @since Nov 30, 2009
 */
@rdf(CLNNamespaceUtils.TYPE_LOCATION)
public interface CLNBusinessLocation extends BenefitBusinessLocation {

    /** @return el id dentro de la nacion de este business location */
    @rdf(CLNNamespaceUtils.CLN_BUSINESS_LOCATION_ID)
    long getId();

    /** @return los benficios que tiene este negocio */
    @rdf(CLNNamespaceUtils.CLN_TYPE_BENEFIT)
    Set<CLNBenefit> getCLNBenefits();
}
