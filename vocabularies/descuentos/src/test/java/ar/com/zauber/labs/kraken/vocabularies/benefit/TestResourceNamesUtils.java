/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.benefit;

import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/**
 * Clase con uris de resources para test
 * @author Mariano Semelman
 * @since Nov 30, 2009
 */
public interface TestResourceNamesUtils {

    /** uri base para todos los recursos del modulo test*/
    String TEST_RESOURCE_BASE = LocationNamespaceUtils.RESOURCE_KRAKEN_BASE
        + "/test-module";
    /** resource de prueba para un requisito */
    String RESOURCE_REQUESITE = TEST_RESOURCE_BASE + "/requisite";
    /** resource de */
    String RESOURCE_LOCATION_BENEFIT = TEST_RESOURCE_BASE + "/";
    /** resource de un benefit type*/
    String RESOURCE_BENEFIT_TYPE = TEST_RESOURCE_BASE + "/benefit-type";
    /** resource de un benefit*/
    String RESOURCE_BENEFIT = TEST_RESOURCE_BASE + "/benefit";

}
