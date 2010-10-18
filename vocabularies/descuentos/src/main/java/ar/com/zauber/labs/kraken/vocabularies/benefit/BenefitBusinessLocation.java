/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.benefit;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;

/**
 * Negocio que tiene beneficio/s.
 * @author Mariano Semelman
 * @since Nov 26, 2009
 */
@rdf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
public interface BenefitBusinessLocation extends BusinessLocation {

    /** @return los beneficio que tiene este negocio */
    @rdf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
    Set<Benefit> getBenefits();

}
