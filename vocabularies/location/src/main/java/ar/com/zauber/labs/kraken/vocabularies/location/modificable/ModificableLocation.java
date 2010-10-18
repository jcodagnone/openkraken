/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
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
