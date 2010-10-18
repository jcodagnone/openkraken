/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.review;

import java.util.Set;

import org.openrdf.concepts.foaf.Person;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

/**
 * A review of an work. This term is deemed to be semantically stable and its 
 * meaning should not change in the foreseable future. Having a reviewer, a 
 * hasFeedback, a totalVotes, a positiveVotes, a title or a hasComment implies 
 * being a member of this class. Things are a member of this class if 
 * they are the value of a has Review. 
 * 
 * @author Juan F. Codagnone
 * @since Dec 1, 2009
 */
@rdf(ReviewNamespaceUtil.TYPE_REVIEW)
public interface Review {

    /** 
     * The person that has written the review. This term is deemed to be 
     * semantically stable and its meaning should not change in the foreseable 
     * future. Having this property implies being a Review. Every value of this 
     * property is a foaf:Person. 
     */
    @rdf(ReviewNamespaceUtil.NS_REVIEWER)
    Person getReviewer();
    
    /** 
     * Number of usefulness votes (integer). Having this property implies being 
     * a Review. Every value of this property is a rdfs:Literal.  
     */
    @rdf(ReviewNamespaceUtil.NS_TOTAL_VOTES)
    int getTotalVotes();
    
    
    /** 
     * Number of positive usefulness votes (integer). Having this property implies
     *  being a Review. Every value of this property is a rdfs:Literal. 
     */
    @rdf(ReviewNamespaceUtil.NS_POSITIVE_VOTES)
    int getPositiveVotes(); 
    
    /** 
     * The title of the review. Having this property implies being a Review. 
     * Every value of this property is a rdfs:Literal. It is a sub-property of 
     * dc:title. 
     */
    @rdf(value = {ReviewNamespaceUtil.NS_TITLE, 
                  "http://purl.org/dc/elements/1.1/title" })
    @localized
    String getTitle();
    
    /**
     * Used to associate a review with a comment on the review. Having this 
     * property implies being a Review. Every value of this property is a Comment. 
     */
    @rdf(ReviewNamespaceUtil.NS_HAS_COMMENT)
    Set<Comment> getComments();
    
    
    /**
     * Associates a review with a feedback on the review. Having this property 
     * implies being a Review. Every value of this property is a Feedback. 
     */
    @rdf(ReviewNamespaceUtil.NS_HAS_FEEDBACK)
    Set<Feedback> getFeedbacks();
    
    /**
     * A numeric value. This term is deemed to be semantically stable and its 
     * meaning should not change in the foreseable future. 
     */
    @rdf(ReviewNamespaceUtil.NS_MAX_RATING)
    int getMaxRating();
    
    /**
     * A numeric value. This term is deemed to be semantically stable and its 
     * meaning should not change in the foreseable future. 
     */
    @rdf(ReviewNamespaceUtil.NS_MIN_RATING)
    int getMinRating();
    
    /**
     *  A numeric value. This term is deemed to be semantically stable and its 
     *  meaning should not change in the foreseable future.  
     */
    @rdf(ReviewNamespaceUtil.NS_RATING)
    int getRating();
    
    /**
     * A numeric value. This term is deemed to be semantically stable and its 
     *  
     */
    @rdf(ReviewNamespaceUtil.NS_TEXT)
    @localized
    String getText();
}
