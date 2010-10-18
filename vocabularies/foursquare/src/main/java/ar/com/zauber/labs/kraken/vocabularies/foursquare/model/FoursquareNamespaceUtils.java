/**
 * Copyright (c) 2009-2010 Zauber S.A. <http://www.zauber.com.ar/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.com.zauber.labs.kraken.vocabularies.foursquare.model;

import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/**
 * Constantes para el namespace de Foursquare
 * 
 * 
 * @author Francisco J. González Costanzó
 * @since Aug 27, 2010
 */
public interface FoursquareNamespaceUtils {

    /** uri base para el namespace */
    String NS_4SQ_BENEFIT_BASE = LocationNamespaceUtils.NS_KRAKEN_BASE
        + "/2010/08/foursquare#";
    
    /** @see FoursquareLocation */
    String TYPE_LOCATION = NS_4SQ_BENEFIT_BASE + "location";

    /** @see FoursquareLocation */
    String NS_4SQ_BUSINESS_LOCATION_ID = TYPE_LOCATION + "-id";

    /** @see FoursquareLocation */
    String NS_4SQ_SHORT_URL = NS_4SQ_BENEFIT_BASE + "short-url";

    /** resource base de foursquare */
    String RESOURCE_FSQ_BASE 
        = LocationNamespaceUtils.RESOURCE_KRAKEN_BASE + "/foursquare/";
    
    /** resource para location de foursquare */
    String RESOURCE_FSQ_LOCATION = RESOURCE_FSQ_BASE + "location/";
    
    /** resource de beneficios de foursquare */
    String RESOURCE_BENEFIT = RESOURCE_FSQ_BASE + "benefit/";
    
}
