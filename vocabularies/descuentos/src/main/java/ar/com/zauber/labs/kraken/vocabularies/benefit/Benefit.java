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
package ar.com.zauber.labs.kraken.vocabularies.benefit;

import java.util.Date;
import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Topic;

/**
 * Representa un Beneficion en un negocio.
 *
 * @author Mariano Semelman
 * @since Nov 26, 2009
 */
@rdf(BenefitNamespaceUtils.TYPE_BENEFIT)
public interface Benefit extends Topic {

    /** @return el business location de donde es este descuento*/
    @inverseOf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
    BenefitBusinessLocation getBusinessLocation();

    /** @return una descripcion de este descuento */
    @localized
    @rdf("http://purl.org/dc/elements/1.1/description")
    String getDescription();

    /** @return el tipo de beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_TYPE)
    BenefitType getType();

    /** @return cuando vence este beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_EXPIRATION)
    Date getExpiration();

    /** @return los requisitos de este beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_REQUISITE)
    Set<Requisite> getRequisites();
}
