/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.review;

import org.openrdf.elmo.annotations.rdf;

/**
 * Feedback on the review. Expresses whether the review was useful or not. 
 * This term is undergoing testing to determine if it is semantically stable and 
 * its meaning may change in the foreseable future. Having a commenter implies 
 * being a member of this class. Things are a member of this class if they are 
 * the value of a hasFeedback. 
 * 
 * @author Juan F. Codagnone
 * @since Dec 1, 2009
 */
@rdf(ReviewNamespaceUtil.TYPE_FEEDBACK)
public interface Feedback extends Comment {

}
