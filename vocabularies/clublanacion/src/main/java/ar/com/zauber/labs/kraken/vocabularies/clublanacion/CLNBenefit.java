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
