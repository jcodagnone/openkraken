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
package ar.com.zauber.labs.kraken.vocabularies.wsg84.utils;

import javax.xml.namespace.QName;

import ar.com.zauber.labs.kraken.vocabularies.wsg84.Point;
import ar.com.zauber.labs.kraken.vocabularies.wsg84.impl.SimplePoint;

/**
 * TODO Descripcion de la clase. Los comenterios van en castellano.
 * 
 * 
 * @author Juan F. Codagnone
 * @since Nov 21, 2009
 */
public final class WSG84Utils {
    private static final Geohash GEOHASH = new Geohash();
    
    /** Creates the WSG84Utils. */
    private WSG84Utils() {
        // utility class
    }
    /** @return un qname donde se codifica una posición, latitude */
    public static QName getQName(final String ns, final double lat, 
            final double lon) {
        return new QName(ns, GEOHASH.encode(lat, lon));
    }
    
    /** @return un punto dado un QName que estaba codificado con geohash */
    public static Point getPoint(final QName name) {
        double []ret = GEOHASH.decode(name.getLocalPart());
        return new SimplePoint(ret[0], ret[1]);
    }
    
    /** verify valid longitude domain */
    public static void validateLongitude(final Double degrees) {
        if(degrees != null) {
            if(degrees < -180 || degrees > 180) {
                throw new IllegalArgumentException(
                        "longitude must be in [-180;180]");
            }
        }
    }
    
    /** verify valid latitude domain */
    public static void validateLatitude(final Double degrees) {
        if(degrees != null) {
            if(degrees < -90 || degrees > 90) {
                throw new IllegalArgumentException("latitude must be in [-90;90]");
            }
        }
    }
}
