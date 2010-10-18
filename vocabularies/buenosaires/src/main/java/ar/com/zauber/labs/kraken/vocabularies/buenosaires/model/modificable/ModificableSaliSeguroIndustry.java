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

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.SaliSeguroIndustry;
import ar.com.zauber.labs.kraken.vocabularies.location.Industry;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableIndustry;

/**
 * Modificable {@link SaliSeguroIndustry}
 * 
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */
@rdf(NamespaceUtils.TYPE_SALI_SEGURO_INDUSTRY)
public interface ModificableSaliSeguroIndustry extends SaliSeguroIndustry,
                                                       ModificableIndustry {

    /** @see Industry#getId() */
    void setId(long id);
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @return el identificador de este rubro */
    @rdf(NamespaceUtils.INDUSTRY_ID)
    long getId();
    
}
