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

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;

/**
 *  modelo de un {@link BusinessLocation} de club la nacion.
 *
 * @author Mariano Semelman
 * @since Nov 30, 2009
 */
@rdf(CLNNamespaceUtils.TYPE_LOCATION)
public interface CLNBusinessLocation extends BenefitBusinessLocation {

    /** @return el id dentro de la nacion de este business location */
    @rdf(CLNNamespaceUtils.CLN_BUSINESS_LOCATION_ID)
    long getId();

    /** @return los benficios que tiene este negocio */
    @rdf(CLNNamespaceUtils.CLN_TYPE_BENEFIT)
    Set<CLNBenefit> getCLNBenefits();
}
