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
package ar.com.zauber.labs.kraken.vocabularies.tagging.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.tagging.Tag;
import ar.com.zauber.labs.kraken.vocabularies.tagging.Tageable;
import ar.com.zauber.labs.kraken.vocabularies.tagging.Tagging;

/**
 * {@link Tageable} modificable (para carga).
 * 
 * 
 * @author Juan Edi
 * @since Dec 4, 2009
 */
public interface ModificableTageable extends Tageable {
    
    /** @see Tageable#getTaggedTag() */
    void setTaggedTag(Set<Tag> taggedTag);
    
    //////////////////////////////////////////////////////////////////////
    

    /** 
     * Indicates that the subject has been tagged with the object tag. This does 
     * not assert by who, when, or why the tagging occurred. For that information,
     *  use a reified Tagging resource
     */
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedWithTag")
    Set<Tag> getTaggedTag();
    
}
