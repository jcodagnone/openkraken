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
