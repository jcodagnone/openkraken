/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.tagging.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.tagging.Tag;
import ar.com.zauber.labs.kraken.vocabularies.tagging.Tageable;
import ar.com.zauber.labs.kraken.vocabularies.tagging.Tagging;

/**
 * {@link Tageable} modificable (para carga).
 * 
 * 
 * @author Juan Edi
 * @since Dec 4, 2009
 */
public interface ModificableTageable extends Tageable {
    
    /** @see Tageable#getTaggedTag() */
    void setTaggedTag(Set<Tag> taggedTag);
    
    //////////////////////////////////////////////////////////////////////
    

    /** 
     * Indicates that the subject has been tagged with the object tag. This does 
     * not assert by who, when, or why the tagging occurred. For that information,
     *  use a reified Tagging resource
     */
    @rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/taggedWithTag")
    Set<Tag> getTaggedTag();
    
}
