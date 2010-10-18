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
package ar.com.zauber.labs.kraken.vocabularies.tagging;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;


/**
 *  Entidad tageable. Se puede asignar tags ({@link #getTaggedTag()} o se
 *  puede asociar un {@link Tagging} que tiene la información de quien asigno
 *  cierto tag, y cuando.
 * 
 * @author Juan F. Codagnone
 * @since Dec 4, 2009
 */
@rdf(TagNamespaceUtils.TYPE_TAGEABLE)
public interface Tageable {

    /**
     * The relationship between a resource and a Tagging. Note, of course, that 
     * this allows us to tag tags and taggings themselves
     */
    @inverseOf(TagNamespaceUtils.TYPE_TAGRESOURCE)
    Set<Tagging> getTaggins();
    

    /** 
     * Indicates that the subject has been tagged with the object tag. This does 
     * not assert by who, when, or why the tagging occurred. For that information,
     *  use a reified Tagging resource
     */
    @rdf(TagNamespaceUtils.TYPE_TAGWITH)
    Set<Tag> getTaggedTag();
}
