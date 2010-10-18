/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.clublanacion;


import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.benefit.Benefit;

/**
 *
 * @author Mariano Semelman
 * @since Nov 27, 2009
 */
@rdf(CLNNamespaceUtils.CLN_TYPE_BENEFIT)
public interface CLNBenefit extends Benefit {

    /** @return el id de este beneficio */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_ID)
    long getId();

    /** @return el estado de este beneficio */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_STATUS)
    Status getStatus();

    /**
     * @return el business location q tiene este descuento.
     */
    @inverseOf(CLNNamespaceUtils.TYPE_LOCATION)
    CLNBusinessLocation getCLNBusinessLocation();
}
