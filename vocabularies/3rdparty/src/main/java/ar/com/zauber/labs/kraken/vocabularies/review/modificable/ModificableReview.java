/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.review.modificable;

import java.util.Set;

import org.openrdf.concepts.foaf.Person;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.review.Comment;
import ar.com.zauber.labs.kraken.vocabularies.review.Feedback;
import ar.com.zauber.labs.kraken.vocabularies.review.Review;
import ar.com.zauber.labs.kraken.vocabularies.review.ReviewNamespaceUtil;

/**
 * {@link Review} que es modificable (para carga)
 * 
 * 
 * @author Juan Edi
 * @since Dec 4, 2009
 */
@rdf(ReviewNamespaceUtil.TYPE_REVIEW)
public interface ModificableReview extends Review {

    /** @see Review#getReviewer() */
    void setReviewer(Person person);
    
    /** @see Review#getTotalVotes() */
    void setTotalVotes(int totalVotes);
    
    /** @see Review#getPositiveVotes() */
    void setPositiveVotes(int positiveVotes); 
    
    /** @see Review#getTitle() */
    void setTitle(String title);
    
    /** @see Review#getComments() */
    void setComments(Set<Comment> comments);
    
    /** @see Review#getFeedbacks() */
    void setFeedbacks(Set<Feedback> feedbacks);
    
    /** @see Review#getMaxRating() */
    void setMaxRating(int maxRating);
    
    /** @see Review#getMinRating() */
    void setMinRating(int minRating);
    
    /** @see Review#getRating() */
    void setRating(int rating);
    
    /** @see Review#getText() */
    void setText(String text);
    
    // Posible bug de Elmo

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
