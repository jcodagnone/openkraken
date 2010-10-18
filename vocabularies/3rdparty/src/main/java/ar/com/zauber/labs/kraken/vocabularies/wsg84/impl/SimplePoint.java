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
