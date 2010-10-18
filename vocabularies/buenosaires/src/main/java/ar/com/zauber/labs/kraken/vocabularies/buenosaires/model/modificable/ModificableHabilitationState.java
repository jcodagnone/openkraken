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

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.HabilitationState;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;

/**
 * {@link HabilitationState} que es modificable (para carga)
 * 
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(NamespaceUtils.TYPE_HABILITATION_STATE)
public interface ModificableHabilitationState extends HabilitationState {

    /** @see HabilitationState#getId() */
    void setId(long id);

    /** Returns the estado. */
    @rdf(NamespaceUtils.HABILTATION_STATE_DESCRIPTION)
    void setDescription(String description);
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** Returns the id. */
    @rdf(NamespaceUtils.HABILTATION_STATE_ID)
    long getId();

        /** Returns the estado. */
    @rdf(NamespaceUtils.HABILTATION_STATE_DESCRIPTION)
    String getDescription();
}
