/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.tagging.modificable;

import java.util.Set;

import org.openrdf.concepts.rdfs.Resource;
import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.tagging.Tag;

/**
 * {@link Tag} modificable (para carga)
 * 
 * 
 * @author Juan Edi
 * @since Dec 4, 2009
 */
@rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tag")
public interface ModificableTag extends Tag {

    /** @see Tag#getName() */
    void setName(String name);
    
    /** @see Tag#getIsTagOf() */
    void setIsTagOf(Set<Resource> isTagOf);
    
    /** @see Tag#getEquivalentTags() */
    void setEquivalentTags(Set<Tag> equivalentTags);
    
    /** @see Tag#getRelatedTags() */
    void setRelatedTags(Set<Resource> relatedTags);
    
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
