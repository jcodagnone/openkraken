/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.wsg84.impl;

import ar.com.zauber.labs.kraken.vocabularies.wsg84.Point;
import ar.com.zauber.labs.kraken.vocabularies.wsg84.utils.WSG84Utils;

/**
 * Simple Implementation of Point
 * 
 * @author Juan F. Codagnone
 * @since Nov 21, 2009
 */
public class SimplePoint implements Point {
    private Double lat;
    private Double lon;
    private Double alt;
    
    /** Creates the SimplePoint. */
    public SimplePoint(final Double lat, final Double lon) {
        this(lat, lon, null);
    }
    
    /** Creates the SimplePoint. */
    public SimplePoint(final Double lat, final Double lon, final Double alt) {
        setLatitude(lat);
        setLongitude(lon);
        setAltitude(alt);
    }
    
    /** @see Point#getAltitude() */
    public final Double getAltitude() {
        return alt;
    }

    /** @see Point#getLatitude() */
    public final Double getLatitude() {
        return lat;
    }

    /** @see Point#getLongitude() */
    public final Double getLongitude() {
        return lon;
    }

    /** @see Point#setAltitude(Double) */
    public final void setAltitude(final Double anAlt) {
        this.alt = anAlt;
    }

    /** @see Point#setLatitude(Double) */
    public final void setLatitude(final Double aLat) {
        WSG84Utils.validateLatitude(aLat);
        this.lat = aLat;
        
    }

    /** @see Point#setLongitude(Double) */
    public final void setLongitude(final Double anLon) {
        WSG84Utils.validateLongitude(anLon);
        this.lon = anLon;
        
    }
}
