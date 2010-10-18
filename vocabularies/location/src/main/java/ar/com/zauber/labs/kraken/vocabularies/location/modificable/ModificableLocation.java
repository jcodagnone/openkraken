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
package ar.com.zauber.labs.kraken.vocabularies.location.modificable;

import java.util.Set;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.Location;
import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.wsg84.Point;

/**
 * {@link Location} que es modificable (para carga)
 * 
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_LOCATION)
public interface ModificableLocation extends Location,  ModificableTopic  {
    
    /** @see Location#getGeoLocation()  */
    @rdf(LocationNamespaceUtils.LOCATION_GEOLOCATION)
    void setGeoLocation(Point point);
    
    /** @see Location#getContains() */
    void setContains(Set<Location> locations);
    
    /** @see Location#getContainedBy() */
    void setContainedBy(Set<Location> locations);
    
    /** @see Location#getAddress() */
    void setAddress(String address);
    
    // DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG)
    /** 
     * @return the longitude and latitude (in decimal notation) of the
     * feature, or of the geographical center (centroid) fo the feature.
     */
    @rdf(LocationNamespaceUtils.LOCATION_GEOLOCATION)
    Point getGeoLocation();
    
    
    /** Other locations within the boundaries of this location.  */
    @rdf(LocationNamespaceUtils.LOCATION_CONTAINS)
    Set<Location> getContains();
    
    
    /** Other locations that this falls within the boundaries of.  */
    @rdf(LocationNamespaceUtils.LOCATION_CONTAINEDBY)
    Set<Location> getContainedBy();
    
    /**
     * @return The street address of this location (if any -- note that many, many 
     * kinds of locations do not have street addresses). Note that this should 
     * not be the mailing address, unless it happens to be the same as the street 
     * address.
     */
    @rdf(LocationNamespaceUtils.LOCATION_ADDRESS)
    String getAddress();
}
