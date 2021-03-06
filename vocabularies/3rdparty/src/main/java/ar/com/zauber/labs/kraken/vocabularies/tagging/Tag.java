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

import org.openrdf.concepts.rdfs.Resource;
import org.openrdf.concepts.skos.core.Concept;
import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

/**
 * A natural-language concept which is used to annotate another resource.
 * 
 * @author Juan F. Codagnone
 * @since Dec 4, 2009
 */
@rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag")
public interface Tag extends Concept {
    
    /**
     * The name of a tag. Note that we can't relate this to skos:prefLabel 
     * because we cannot guarantee that tags have unique labels in a given 
     * conceptual scheme. Or can we?
     */
    @localized
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/name")
    String getName();
    
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/isTagOf")
    @inverseOf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedWithTag")
    Set<Resource> getIsTagOf();
    
    /** The two tags are asserted to be equivalent --- that is, that whenever one 
     * is associated with a resource, the other tag can be logically inferred to 
     * also be associated. Be very careful with this. I'm not sure if this should 
     * be a subproperty of owl:sameAs
    */
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/equivalentTag")
    Set<Tag> getEquivalentTags();
    
    /**
     * The two tags are asserted as being related. This might be symmetric, 
     * but it certainly isn't transitive. 
     */
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/relatedTag")
    Set<Resource> getRelatedTags();
    
    
}
