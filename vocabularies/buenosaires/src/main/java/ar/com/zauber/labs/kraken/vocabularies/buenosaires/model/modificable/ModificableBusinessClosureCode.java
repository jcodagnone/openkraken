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
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.BusinessClosureCode;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;

/**
 * {@link BusinessClosureCode} modificable
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(NamespaceUtils.TYPE_BUSINESS_CLOSURE_CODE)
public interface ModificableBusinessClosureCode extends BusinessClosureCode {
    /** @see BusinessClosureCode#getId() */
    void setId(long id);

    /** @see BusinessClosureCode#getName() */
    void setDescription(String reason);
    
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @return el identificador de la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE_ID)
    long getId();

    /** @return un texto en humano sobre la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE_DESCRIPTION)
    String getDescription();
    
}
