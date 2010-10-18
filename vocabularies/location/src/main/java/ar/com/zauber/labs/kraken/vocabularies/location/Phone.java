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
package ar.com.zauber.labs.kraken.vocabularies.location;

import org.openrdf.elmo.annotations.rdf;

/**
 * Representa un numero de telefono.
 *
 * @author Mariano Semelman
 * @since Nov 24, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_PHONE)
public interface Phone  extends Topic {

    /** @return numero de telefono */
    @rdf(value = {
            LocationNamespaceUtils.PHONE_NUMBER, 
            "http://purl.org/dc/elements/1.1/title"
        })
    String getNumber();
}
