/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.benefit;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Topic;

/**
 * los requisitos para acceder a cierto {@link Benefit}
 * @author Mariano Semelman
 * @since Nov 26, 2009
 */
@rdf(BenefitNamespaceUtils.BENEFIT_REQUISITE)
public interface Requisite extends Topic {

    /** @return los beneficios que tienen este requisito */
    @inverseOf(BenefitNamespaceUtils.BENEFIT_REQUISITE)
    Set<Benefit> getBenefitsWithThisRequisite();

}
