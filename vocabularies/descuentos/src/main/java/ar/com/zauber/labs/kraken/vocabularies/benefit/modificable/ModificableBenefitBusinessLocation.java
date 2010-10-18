/*
 * Copyright (c) 2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.benefit.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.benefit.Benefit;
import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitNamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableBusinessLocation;

/**
 * {@link BenefitBusinessLocation} que es mutable
 * 
 * @author Pablo Martin Grigolatto
 * @since Sep 3, 2010
 */
@rdf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
public interface ModificableBenefitBusinessLocation 
    extends BenefitBusinessLocation, ModificableBusinessLocation {

    /** @see BenefitBusinessLocation#getBenefits() */
    void setBenefits(Set<Benefit> benefits);
    
    // XXX bug de ELMO, me obliga a duplicar el metodo
    /** @return los beneficio que tiene este negocio */
    @rdf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
    Set<Benefit> getBenefits();
    
}
