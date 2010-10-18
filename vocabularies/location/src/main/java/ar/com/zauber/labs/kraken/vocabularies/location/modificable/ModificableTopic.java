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

import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.location.Topic;

/**
 * Modificable {@link Topic}
 * 
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_TOPIC)
public interface ModificableTopic extends Topic {

    /** @see Topic#getName() */
    void setTitle(String name);
    
    // DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) ///
    /** @return nombre representativo */
    @rdf(LocationNamespaceUtils.TOPIC_NAME)
    @localized
    String getTitle();
}
