/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.review;

import org.openrdf.concepts.foaf.Agent;
import org.openrdf.elmo.annotations.rdf;

/**
 * A comment on a review. Having a commenter implies being a member of this 
 * class. Things are a member of this class if they are the value of a hasComment. 
 * 
 * @author Juan F. Codagnone
 * @since Dec 1, 2009
 */
@rdf(ReviewNamespaceUtil.TYPE_COMMENT)
public interface Comment {
    /** 
     * The commenter on the review. Having this property implies being a Feedback
     *  and a Comment. Every value of this property is a foaf:Agent. 
     */
    @rdf(ReviewNamespaceUtil.NS_COMMENTER)
    Agent getCommenter();
}
