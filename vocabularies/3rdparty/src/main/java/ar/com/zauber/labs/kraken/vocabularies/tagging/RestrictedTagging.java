/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.tagging;

import org.openrdf.elmo.annotations.rdf;

/**
 * A Tagging which has precisely one associated resource, and one associated tag.
 * 
 * @author Juan F. Codagnone
 * @since Dec 4, 2009
 */
@rdf("http://www.holygoat.co.uk/owl/redwood/0.1/tags/RestrictedTagging")
public interface RestrictedTagging extends Tagging {

    // TODO
}
