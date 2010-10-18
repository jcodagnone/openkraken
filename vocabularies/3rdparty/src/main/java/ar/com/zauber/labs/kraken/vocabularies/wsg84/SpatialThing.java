/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.wsg84;

import org.openrdf.elmo.annotations.rdf;

/**
 * Anything with spatial extent, i.e. size, shape, or position. e.g. people, 
 * places, bowling balls, as well as abstract areas like cubes. 
 * 
 * @author Juan F. Codagnone
 * @since Nov 21, 2009
 */
@rdf(SpatialThing.NS + "SpatialThing")
public interface SpatialThing {
    /** namespace base */
    String NS = "http://www.w3.org/2003/01/geo/wgs84_pos#";
    
}
