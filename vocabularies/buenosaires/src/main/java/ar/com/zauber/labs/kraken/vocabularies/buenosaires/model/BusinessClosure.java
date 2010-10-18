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
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import java.util.Date;

import org.openrdf.elmo.annotations.rdf;

/**
 * Clausura de un local
 * 
 * @author Juan F. Codagnone
 * @since Nov 21, 2009
 */
@rdf(NamespaceUtils.TYPE_BUSINESS_CLOSURE)
public interface BusinessClosure {

    /** @return la tificacionde la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE)
    BusinessClosureCode getClosureReason();
    
    /** Returns the fechaClausura. */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_DATE)
    Date getClosureDate();
    
    /** lugares clausurados */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_LOCATION)
    SaliSeguroLocation getLocation();
}
