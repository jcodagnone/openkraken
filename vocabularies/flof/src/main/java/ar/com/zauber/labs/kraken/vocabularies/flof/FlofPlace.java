/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.flof;

import java.util.Set;

import org.openrdf.concepts.foaf.Image;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Location;
import ar.com.zauber.labs.kraken.vocabularies.review.Reviewable;
import ar.com.zauber.labs.kraken.vocabularies.tagging.Tageable;

/**
 * Un lugar de flof
 * 
 * @author Juan F. Codagnone
 * @since Dec 4, 2009
 */
public interface FlofPlace extends Location, Reviewable, Tageable {

    /** the place depictions */
    @rdf("http://xmlns.com/foaf/0.1/depiction")
    Set<Image> getDepictions();
    
}
