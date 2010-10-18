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

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

/**
 * Representa el código de una clausura de un local
 * 
 * @author Marcelo Turrin
 * @since Nov 19, 2009
 */
@rdf(NamespaceUtils.TYPE_BUSINESS_CLOSURE_CODE)
public interface BusinessClosureCode {
    
    /** @return el identificador de la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE_ID)
    long getId();

    /** @return un texto en humano sobre la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE_DESCRIPTION)
    @localized
    String getDescription();
    
    /** @return las clausuras hechas bajo este código */
    @inverseOf(NamespaceUtils.BUSINESS_CLOSURE_CODE)
    Set<BusinessClosure> getClousures();
}
