/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.benefit;

import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/**
 * Namespace constants
 *
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */

public interface BenefitNamespaceUtils {

    /** Namespace base para todos los conceptos */
    String NS_BENEFIT_BASE = LocationNamespaceUtils.NS_KRAKEN_BASE
        + "/2009/11/benefit#";


    /** @see Benefit */
    String TYPE_BENEFIT = NS_BENEFIT_BASE + "benefit";

    /** @see Benefit */
    String BENEFIT_EXPIRATION = NS_BENEFIT_BASE + "expiration";

    /** @see Benefit */
    String BENEFIT_TYPE = NS_BENEFIT_BASE + "type";

    /** @see Benefit */
    String BENEFIT_REQUISITE = NS_BENEFIT_BASE + "requisite";

    /** @see BenefitBusinessLocation */
    String BUSINESS_LOCATION_BENEFIT =
        LocationNamespaceUtils.TYPE_BUSINESS_LOCATION + "-benefit";

}
