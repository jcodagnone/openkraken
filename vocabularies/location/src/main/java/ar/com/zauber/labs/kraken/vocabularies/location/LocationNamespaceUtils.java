/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location;



/**
 * Constantes de namespace
 *
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */
public interface LocationNamespaceUtils {
    /** dominio base de kraken*/
    String KRAKEN_DOMAIN = "http://kraken.zauber.com.ar";
    
    /** base para todo kraken */
    String NS_KRAKEN_BASE = KRAKEN_DOMAIN + "/ns";
    
    /** base para todos los recursos especificos de  kraken */
    String RESOURCE_KRAKEN_BASE = KRAKEN_DOMAIN + "/resource";

    /** recurso que representa a buenos aires */
    String RESOURCE_BUENOS_AIRES = "http://rdf.freebase.com/ns/en.buenos_aires";
    /** Namespace base para todos los conceptos */
    String NS_LOCATION_BASE = NS_KRAKEN_BASE + "/2009/11/location#";

    /** @see Location */
    String TYPE_LOCATION = NS_LOCATION_BASE + "location";

    /** @see Location#getGeoLocation()*/
    String LOCATION_GEOLOCATION = TYPE_LOCATION + "-geocode";
    /** @see Location#getContains() */
    String LOCATION_CONTAINS = TYPE_LOCATION + "-contains";
    /** @see Location#getContainedBy() */
    String LOCATION_CONTAINEDBY = TYPE_LOCATION + "-containedby";

    /** @see Location#getAddress() */
    String LOCATION_ADDRESS = TYPE_LOCATION + "-address";

    /** @see Company */
    String TYPE_COMPANY   = NS_LOCATION_BASE + "company";
    /** @see Company#getCuit() */
    String COMPANY_CUIT   = NS_LOCATION_BASE + "company-cuit";

    /** @see BusinessLocation */
    String TYPE_TOPIC     = NS_LOCATION_BASE + "topic";
    /** @see BusinessLocation#getName() */
    String TOPIC_NAME     = "http://purl.org/dc/elements/1.1/title";

    /** @see BusinessLocation */
    String TYPE_BUSINESS_LOCATION     = NS_LOCATION_BASE + "business-location";
    /** @see BusinessLocation#getCompany() */
    String BUSINESS_LOCATION_OWNER_BY  = TYPE_BUSINESS_LOCATION + "-owned-by";

    /** @see BusinessLocation#getIndustry() */
    String BUSINESS_LOCATION_PRIMARY_INDUSTRY = TYPE_BUSINESS_LOCATION
        + "-primary-industry";
    /** @see Industry */
    String BUSINESS_LOCATION_SECUNDARY_INDUSTRY = TYPE_BUSINESS_LOCATION
        + "-secundary-industry";
    
    /** @see BusinessLocation#getPhone() */
    String BUSINESS_LOCATION_PHONE = TYPE_BUSINESS_LOCATION + "-phone";

    /** @see Industry */
    String TYPE_INDUSTRY = NS_LOCATION_BASE + "industry";
    
    /** @see Phone */
    String TYPE_PHONE = NS_LOCATION_BASE + "phone";
    /** @see Phone#getNumber() */
    String PHONE_NUMBER = TYPE_PHONE + "-number";
}
