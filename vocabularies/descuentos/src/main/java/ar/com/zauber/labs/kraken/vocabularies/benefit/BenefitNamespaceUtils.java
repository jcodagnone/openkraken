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
