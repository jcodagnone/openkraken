/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.clublanacion;

import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/*
 * Copyright (c) 2009 Zauber S.A.  -- All rights reserved
 */

/**
 * Constantes de Namespace para club la nacion.
 *
 * @author Mariano Semelman
 * @since Nov 27, 2009
 */
public interface CLNNamespaceUtils {

    /** uri base para el namespace */
    String NS_CLN_BENEFIT_BASE = LocationNamespaceUtils.NS_KRAKEN_BASE
        + "/2009/11/clublanacion#";
    /** @see CLNBenefit */
    String CLN_TYPE_BENEFIT = NS_CLN_BENEFIT_BASE + "clnbenefit";

    /** @see CLNBenefit */
    String CLN_BENEFIT_STATUS = CLN_TYPE_BENEFIT + "-status";

    /** @see CLNBenefit */
    String CLN_BENEFIT_ID = CLN_TYPE_BENEFIT + "-id";

    /** @see CLNBusinessLocation */
    String TYPE_LOCATION = NS_CLN_BENEFIT_BASE + "location";

    /** @see CLNBusinessLocation */
    String CLN_BUSINESS_LOCATION_ID = TYPE_LOCATION + "-id";

    /** rescource base de la nacion */
    String RESOURCE_LANACION =
        LocationNamespaceUtils.RESOURCE_KRAKEN_BASE + "/clublanacion";

    /** resource de un beneficio de la nacion */
    String RESOURCE_BENEFIT = RESOURCE_LANACION + "/benefit";

    /** resource de un benefit type */
    String RESOURCE_BENEFIT_TYPE = RESOURCE_LANACION + "/benefit-type";

    /** resource de uin requisite */
    String RESOURCE_REQUESITE = RESOURCE_LANACION + "/requisite";

    /** resource un status de la nacion */
    String RESOURCE_STATUS = RESOURCE_LANACION + "/status";

    /** resource de un business location de la nacion */
    String RESOURCE_LOCATION = RESOURCE_LANACION + "/location";

    /** resource de una industry */
    String RESOURCE_INDUSTRY = RESOURCE_LANACION + "/industry";


}
