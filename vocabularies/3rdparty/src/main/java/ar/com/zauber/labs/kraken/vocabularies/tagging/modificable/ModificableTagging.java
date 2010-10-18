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

import java.util.Date;
import java.util.Set;

import org.openrdf.concepts.foaf.Agent;
import org.openrdf.concepts.rdfs.Resource;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.tagging.Tag;
import ar.com.zauber.labs.kraken.vocabularies.tagging.Tagging;

/**
 * {@link Tagging} modificable (para carga).
 * 
 * 
 * @author Juan Edi
 * @since Dec 7, 2009
 */
public interface ModificableTagging extends Tagging {

    /** @see Tagging#getTag() */
    void setTag(Set<Tag> tag);
    
    /** @see Tagging#getTaggedBy() */
    void setTaggedBy(Agent agent);

    /** @see Tagging#getTaggedOn() */
    void setTaggedOn(Date taggedOn);
    
    /** The object is a resource which plays a role in the subject Tagging */
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedResource")
    void setTaggedWithTag(Resource resource);
    
    //////////////////////////////////////////////////////////////////
    
    /** The object is a Tag which plays a role in the subject Tagging */
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/associatedTag")
    Set<Tag> getTag();
    

    /** The object plays the role of the tagger in the subject Tagging.*/
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedBy")
    Agent getTaggedBy();

    /** tagged on */
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedOn")
    Date getTaggedOn();
    
    
    /** The object is a resource which plays a role in the subject Tagging */
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedResource")
    Resource getTaggedWithTag();
    
}
