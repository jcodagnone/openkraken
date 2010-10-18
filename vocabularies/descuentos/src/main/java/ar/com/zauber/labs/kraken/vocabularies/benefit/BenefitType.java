/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.benefit;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Topic;

/**
 * Tipo de beneficio:
 *      Discount
 *      Bonification
 *      Promotion
 *      ...
 *
 * @author Mariano Semelman
 * @since Nov 26, 2009
 */
@rdf(BenefitNamespaceUtils.BENEFIT_TYPE)
public interface BenefitType extends Topic {

    /** @return todos los beneficios que tienen este tipo de beneficio*/
    @inverseOf(BenefitNamespaceUtils.BENEFIT_TYPE)
    Set<Benefit> getBenefitsWithThisType();

}
