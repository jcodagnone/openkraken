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
package ar.com.zauber.labs.kraken.vocabularies.clublanacion.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNBenefit;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNNamespaceUtils;

/**
 * Business location de la nacion modificable (fines de test)
 *
 * @author Mariano Semelman
 * @since Dec 1, 2009
 */
@rdf(CLNNamespaceUtils.TYPE_LOCATION)
public interface ModificableCLNBusinessLocation extends CLNBusinessLocation {

    /** setea el id */
    @rdf(CLNNamespaceUtils.CLN_BUSINESS_LOCATION_ID)
    void setId(long id);

    //XXX elmo bug
    /** @return el id dentro de la nacion de este business location */
    @rdf(CLNNamespaceUtils.CLN_BUSINESS_LOCATION_ID)
    long getId();

    /** @return los benficios que tiene este negocio */
    @rdf(CLNNamespaceUtils.CLN_TYPE_BENEFIT)
    Set<CLNBenefit> getCLNBenefits();
}
