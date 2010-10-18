/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.tagging;

import java.util.Date;
import java.util.Set;

import org.openrdf.concepts.foaf.Agent;
import org.openrdf.concepts.rdfs.Resource;
import org.openrdf.elmo.annotations.rdf;

/**
 * A reified class which defines an instance of a tagging by an agent of a 
 * resource with one or more tags.
 * 
 * 
 * @author Juan F. Codagnone
 * @since Dec 4, 2009
 */
@rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/Tagging")
public interface Tagging {
    
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
