/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.review;

import java.util.Set;

import org.openrdf.concepts.rdfs.Resource;
import org.openrdf.elmo.annotations.rdf;

/**
 * Thing that can be reviewed 
 * 
 * @author Juan F. Codagnone
 * @since Dec 2, 2009
 */
@rdf("http://www.w3.org/2000/01/rdf-schema#Resource")
public interface Reviewable extends Resource {

    /**
     * Associates a work with a a review. This term is deemed to be semantically 
     * stable and its meaning should not change in the foreseable future. Having 
     * this property implies being a rdfs:Resource. Every value of this property 
     * is a {@link Review}.
     */
    @rdf(ReviewNamespaceUtil.NS_HAS_REVIEW)
    Set<Review> getReviews();
}
