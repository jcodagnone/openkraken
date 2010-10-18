/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.wsg84;

import org.openrdf.elmo.annotations.rdf;

/**
 * A point, typically described using a coordinate system relative to Earth, 
 * such as WGS84. 
 * 
 * Uniquely identified by lat/long/alt. i.e. spaciallyIntersects(P1, P2) :- 
 *   lat(P1, LAT), long(P1, LONG), alt(P1, ALT), lat(P2, LAT), long(P2, LONG), 
 *   alt(P2, ALT). sameThing(P1, P2) :- type(P1, Point), type(P2, Point), 
 *   spaciallyIntersects(P1, P2). 
 * 
 * @author Juan F. Codagnone
 * @since Nov 21, 2009
 */
@rdf(SpatialThing.NS + "Point")
public interface Point extends SpatialThing {
    
    /** The WGS84 latitude of a SpatialThing (decimal degrees). (can be null) */
    @rdf(SpatialThing.NS + "lat")
    Double getLatitude();
    
    /** The WGS84 longitude of a SpatialThing (decimal degrees). (can be null) */
    @rdf(SpatialThing.NS + "long")
    Double getLongitude();

    /** altitude (can be null) */
    @rdf(SpatialThing.NS + "alt")
    Double getAltitude();
    
    /** @see #getLatitude() */
    void setLatitude(Double lat);
    /** @see #getLatitude() */
    void setLongitude(Double lon);
    /** @see #getAltitude() */
    void setAltitude(Double alt);
}
