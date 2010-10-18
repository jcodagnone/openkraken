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
package ar.com.zauber.labs.kraken.vocabularies.location.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.Company;
import ar.com.zauber.labs.kraken.vocabularies.location.Industry;
import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/**
 * {@link BusinessLocation} que es modificable (para carga)
 * 
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_BUSINESS_LOCATION)
public interface ModificableBusinessLocation extends BusinessLocation, 
                                                     ModificableLocation {


    /** @see BusinessLocation#getCompany() */
    void setCompany(Company company);

    /** @see BusinessLocation#getIndustry() */
    void setIndustry(Industry industry);

    /** @see BusinessLocation#getSecundaryIndustry() */
    void setSecundaryIndustry(Industry industry);
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @return la compania del {@link BusinessLocation} */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_OWNER_BY)
    Company getCompany();

    /** @return el rubro del del {@link BusinessLocation} */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_PRIMARY_INDUSTRY)
    Industry getIndustry();

    /** @return el rubro secundario (puede ser nulo) */
    @rdf(LocationNamespaceUtils.BUSINESS_LOCATION_SECUNDARY_INDUSTRY)
    Industry getSecundaryIndustry();
}
