/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.clublanacion;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

/**
 * modelo para un estado de de un beneficio de club la nacion.
 *
 *
 * @author Mariano Semelman
 * @since Nov 27, 2009
 */
@rdf(CLNNamespaceUtils.CLN_BENEFIT_STATUS)
public interface Status {

    /** @return todos los benefit */
    @inverseOf(CLNNamespaceUtils.CLN_BENEFIT_STATUS)
    Set<CLNBenefit> getBenefitsWithThisStatus();
}
