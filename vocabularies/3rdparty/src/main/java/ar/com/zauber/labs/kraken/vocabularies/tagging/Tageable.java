/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.tagging;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;


/**
 *  Entidad tageable. Se puede asignar tags ({@link #getTaggedTag()} o se
 *  puede asociar un {@link Tagging} que tiene la información de quien asigno
 *  cierto tag, y cuando.
 * 
 * @author Juan F. Codagnone
 * @since Dec 4, 2009
 */
@rdf(TagNamespaceUtils.TYPE_TAGEABLE)
public interface Tageable {

    /**
     * The relationship between a resource and a Tagging. Note, of course, that 
     * this allows us to tag tags and taggings themselves
     */
    @inverseOf(TagNamespaceUtils.TYPE_TAGRESOURCE)
    Set<Tagging> getTaggins();
    

    /** 
     * Indicates that the subject has been tagged with the object tag. This does 
     * not assert by who, when, or why the tagging occurred. For that information,
     *  use a reified Tagging resource
     */
    @rdf(TagNamespaceUtils.TYPE_TAGWITH)
    Set<Tag> getTaggedTag();
}
