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

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Location;


/**
 * Location que tiene información especifica del catastro de buenos aires.
 * 
 * @author Juan F. Codagnone
 * @since Nov 19, 2009
 */
@rdf(NamespaceUtils.TYPE_BUE_LOCATION)
public interface BuenosAiresLocation extends Location {
    /** @return la manzana donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_BLOCK)
    String getBlock();

    /** @return la sección donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_SECTION)
    Integer getSection();

    /** @return la parcela donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_LOT)
    String getLot();
    
    /** @return el codigo de puerta de donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_DOORCODE)
    Integer getDoorCode();
}
