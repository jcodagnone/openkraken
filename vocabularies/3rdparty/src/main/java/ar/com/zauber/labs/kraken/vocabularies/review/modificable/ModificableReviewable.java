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
package ar.com.zauber.labs.kraken.vocabularies.review.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.review.Review;
import ar.com.zauber.labs.kraken.vocabularies.review.ReviewNamespaceUtil;
import ar.com.zauber.labs.kraken.vocabularies.review.Reviewable;

/**
 * {@link Reviewable} modificable (para carga).
 * 
 * 
 * @author Juan Edi
 * @since Dec 4, 2009
 */
public interface ModificableReviewable extends Reviewable {

    /** see Reviewable#getReviews() */
    void setReviews(Set<? extends Review> reviews);
    
    // DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG)
    /**
     * Associates a work with a a review. This term is deemed to be semantically 
     * stable and its meaning should not change in the foreseable future. Having 
     * this property implies being a rdfs:Resource. Every value of this property 
     * is a {@link Review}.
     */
    @rdf(ReviewNamespaceUtil.NS_HAS_REVIEW)
    Set<Review> getReviews();
    
}
