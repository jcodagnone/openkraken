/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.review;

/**
 * Constantes de namespaces
 * 
 * @author Juan F. Codagnone
 * @since Dec 1, 2009
 */
public interface ReviewNamespaceUtil {
    /** namespace base*/
    String NS_REVIEW_BASE = "http://purl.org/stuff/rev#";
    /** @see Review */
    String TYPE_REVIEW =  NS_REVIEW_BASE + "Review";
    /** @see Comment */
    String TYPE_COMMENT =  NS_REVIEW_BASE + "Comment";
    /** @see Feedback */
    String TYPE_FEEDBACK =  NS_REVIEW_BASE + "Feedback";
    /** @see Review#getFeedbacks() */
    String NS_REVIEWER = NS_REVIEW_BASE + "reviewer";
    /** @see Review#getFeedbacks() */
    String NS_HAS_FEEDBACK = NS_REVIEW_BASE + "hasFeedback";
    /** @see Review#getTotalVotes() */
    String NS_TOTAL_VOTES = NS_REVIEW_BASE + "totalVotes";
    /** @see Review#getPositiveVotes() */
    String NS_POSITIVE_VOTES = NS_REVIEW_BASE + "positiveVotes";
    /** @see Review#getTitle() */
    String NS_TITLE = NS_REVIEW_BASE + "title";
    /** @see Review#getComments() /
    String NS_COMMENTS = NS_REVIEW_BASE + "hasComment";
    /** @see Comment#getCommenter()*/
    String NS_COMMENTER = NS_REVIEW_BASE + "commenter";
    /** @see Reviewable#getReviews() */
    String NS_HAS_REVIEW = NS_REVIEW_BASE + "hasReview";
    /** @see Review#getMaxRating() */
    String NS_MAX_RATING = NS_REVIEW_BASE + "maxRating";
    /** @see Review#getMinRating() */
    String NS_MIN_RATING = NS_REVIEW_BASE + "minRating";
    /** @see Review#getRating() */
    String NS_RATING = NS_REVIEW_BASE + "rating";
    /** @see Review#getText() */
    String NS_TEXT = NS_REVIEW_BASE + "text";
    /** @see Review#getComments()*/
    String NS_HAS_COMMENT = NS_REVIEW_BASE + "hasComment";
}
