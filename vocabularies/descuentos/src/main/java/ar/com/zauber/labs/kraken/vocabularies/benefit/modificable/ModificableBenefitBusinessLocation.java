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
package ar.com.zauber.labs.kraken.vocabularies.benefit.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.benefit.Benefit;
import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitNamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableBusinessLocation;

/**
 * {@link BenefitBusinessLocation} que es mutable
 * 
 * @author Pablo Martin Grigolatto
 * @since Sep 3, 2010
 */
@rdf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
public interface ModificableBenefitBusinessLocation 
    extends BenefitBusinessLocation, ModificableBusinessLocation {

    /** @see BenefitBusinessLocation#getBenefits() */
    void setBenefits(Set<Benefit> benefits);
    
    // XXX bug de ELMO, me obliga a duplicar el metodo
    /** @return los beneficio que tiene este negocio */
    @rdf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
    Set<Benefit> getBenefits();
    
}
