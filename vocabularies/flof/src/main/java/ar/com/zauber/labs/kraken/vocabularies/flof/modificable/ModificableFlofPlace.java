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
package ar.com.zauber.labs.kraken.vocabularies.flof.modificable;

import java.util.Set;

import org.openrdf.concepts.foaf.Image;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.flof.FlofPlace;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableLocation;
import ar.com.zauber.labs.kraken.vocabularies.review.modificable.ModificableReviewable;
import ar.com.zauber.labs.kraken.vocabularies.tagging.modificable.ModificableTageable;

/**
 * {@link Flofplace} modificable (para carga)
 * 
 * 
 * @author Juan Edi
 * @since Dec 4, 2009
 */
public interface ModificableFlofPlace extends FlofPlace, ModificableLocation,
        ModificableReviewable, ModificableTageable {

    /** @see Flofplace#getDepictions() */
    void setDepictions(Set<Image> depictions);
    
    // DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG)
    /** the place depictions */
    @rdf("http://xmlns.com/foaf/0.1/depiction")
    Set<Image> getDepictions();
    

}
