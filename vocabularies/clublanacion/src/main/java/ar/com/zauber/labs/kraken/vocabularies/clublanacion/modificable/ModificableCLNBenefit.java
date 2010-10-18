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

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNBenefit;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNNamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.Status;

/**
 * {@link CLNBenefit} modificable, para tests.
 * @author Mariano Semelman
 * @since Dec 1, 2009
 */
public interface ModificableCLNBenefit extends CLNBenefit {

    /**
     * setea el business location al que pertenece este benefit.
     */
    @inverseOf(CLNNamespaceUtils.TYPE_LOCATION)
    void setCLNBusinessLocation(CLNBusinessLocation business);

    /** setea el status
     * @param st
     * */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_STATUS)
    void setStatus(Status st);

    /** setea el id */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_ID)
    void setId(long id);

    //XXX elmo bug
    /** */
    @inverseOf(CLNNamespaceUtils.TYPE_LOCATION)
    CLNBusinessLocation  getCLNBusinessLocation();


    /** */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_STATUS)
    Status getStatus();

    /** @return el id */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_ID)
    long getId();

}
