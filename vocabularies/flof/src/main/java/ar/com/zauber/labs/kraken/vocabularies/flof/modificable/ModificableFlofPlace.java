/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.flof.modificable;

import java.util.Set;

import org.openrdf.concepts.foaf.Image;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.flof.FlofPlace;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableLocation;
import ar.com.zauber.labs.kraken.vocabularies.review.modificable.ModificableReviewable;
import ar.com.zauber.labs.kraken.vocabularies.tagging.modificable.ModificableTageable;

/**
 * {@link Flofplace} modificable (para carga)
 * 
 * 
 * @author Juan Edi
 * @since Dec 4, 2009
 */
public interface ModificableFlofPlace extends FlofPlace, ModificableLocation,
        ModificableReviewable, ModificableTageable {

    /** @see Flofplace#getDepictions() */
    void setDepictions(Set<Image> depictions);
    
    // DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG)
    /** the place depictions */
    @rdf("http://xmlns.com/foaf/0.1/depiction")
    Set<Image> getDepictions();
    

}
