/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.Company;
import ar.com.zauber.labs.kraken.vocabularies.location.Industry;
import ar.com.zauber.labs.kraken.vocabularies.location.Location;
import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;




/**
 * Constantes de namespace
 * 
 * @author Juan F. Codagnone
 * @since Nov 18, 2009
 */
public interface NamespaceUtils {
    
    /** Namespace base para todos los conceptos */
    String NS_BASE = LocationNamespaceUtils.NS_KRAKEN_BASE + "/2009/11/saliseguro#";
    /** URL base para todos los recursos */
    String RESOURCE_BASE = LocationNamespaceUtils.RESOURCE_KRAKEN_BASE 
            + "/saliseguro/";
    
      /** {@link Company} qname */
    String RESOURCE_COMPANY = RESOURCE_BASE + "company/";
    
    /** {@link HabilitationState} qname */
    String RESOURCE_INDUSTRY = RESOURCE_BASE + "industry/";
    /** @see Industry */
    String TYPE_SALI_SEGURO_INDUSTRY = NS_BASE + "saliseguro-industry";
    /** @see Industry#getId() */
    String INDUSTRY_ID = TYPE_SALI_SEGURO_INDUSTRY + "-id";

    
    /** @see SaliSeguroLocation */
    String TYPE_SALI_SEGURO_LOCATION = NS_BASE + "sali-seguro-location";
    /** @see BusinessLocation#getId() */
    String SALI_SEGURO_LOCATION_ID       = TYPE_SALI_SEGURO_LOCATION + "-id";
    /** @see BusinessLocation#getHabilitationState() */
    /** @see SaliSeguroLocation#getSurface() */
    String SALI_SEGURO_LOCATION_SURFACE = TYPE_SALI_SEGURO_LOCATION + "-surface";
    /** @see Location#getCapacity() */
    String SALI_SEGURO_LOCATION_CAPACITY = TYPE_SALI_SEGURO_LOCATION + "-capacity";
    String SALI_SEGURO_LOCATION_HABILITATION_STATE = 
        TYPE_SALI_SEGURO_LOCATION + "habilitation-state";
    /** @see SaliSeguroLocation#getAmountClosures() */
    String SALI_SEGURO_LOCATION_CLOSURES = 
        TYPE_SALI_SEGURO_LOCATION + "closures";
    /** @see SaliSeguroLocation#getAmountClosures() */
    String SALI_SEGURO_LOCATION_AMOUNT_CLOSURE = 
        TYPE_SALI_SEGURO_LOCATION + "amount-closures";
    
    /** {@link HabilitationState} qname */
    String RESOURCE_HABILITATION_STATE  = RESOURCE_BASE + "habilitation-state/";
    /** @see HabilitationState */
    String TYPE_HABILITATION_STATE = NS_BASE + "habilitation-state";
    /** @see HabilitationState#getId() */
    String HABILTATION_STATE_ID = TYPE_HABILITATION_STATE + "-id";
    /** @see HabilitationState#getDescription() */
    String HABILTATION_STATE_DESCRIPTION = 
        TYPE_HABILITATION_STATE + "-description";
    
    
    
    /** {@link Location} qname */
    String RESOURCE_LOCATION = RESOURCE_BASE + "location/";
    

    /** @see BuenosAiresLocation */
    String TYPE_BUE_LOCATION = NS_BASE + "bue-location";
    /** @see Location#getBlock() */
    String BUE_LOCATION_BLOCK = TYPE_BUE_LOCATION + "-block";
    /** @see Location#getSection()*/
    String BUE_LOCATION_SECTION = TYPE_BUE_LOCATION + "-section";
    /** @see Location#getLot() */
    String BUE_LOCATION_LOT = TYPE_BUE_LOCATION + "-lot";
    /** @see Location#getDoorCode() */
    String BUE_LOCATION_DOORCODE = TYPE_BUE_LOCATION + "-door-code";

    /** {@link BusinessClosureCode} qname */
    String RESOURCE_BUSINESS_CLOSURE_CODE = RESOURCE_BASE + "closure-code/";
    /** @see BusinessLocation */
    String TYPE_BUSINESS_CLOSURE_CODE = NS_BASE + "closure-code";
    /** @see BusinessClosureCode#getId() */
    String BUSINESS_CLOSURE_CODE_ID = TYPE_BUSINESS_CLOSURE_CODE + "-id";
    /** @see BusinessClosureCode#getName() */
    String BUSINESS_CLOSURE_CODE_DESCRIPTION = TYPE_BUSINESS_CLOSURE_CODE 
        + "-description";

    /** {@link BusinessClosure} qname */
    String RESOURCE_BUSINESS_CLOSURE = RESOURCE_BASE + "closure/";
    /** @see BusinessLocation */
    String TYPE_BUSINESS_CLOSURE = NS_BASE + "closure";
    /** @see BusinessClosure#getClosureDate() */
    String BUSINESS_CLOSURE_DATE = 
        TYPE_BUSINESS_CLOSURE + "-date";
    /** @see SaliSeguroLocation#getClosureReason() */
    String BUSINESS_CLOSURE_CODE = 
        TYPE_BUSINESS_CLOSURE + "-code";
    /** @see SaliSeguroLocation#getClosureReason() */
    String BUSINESS_CLOSURE_LOCATION = 
        TYPE_BUSINESS_CLOSURE + "-location";
    
}
