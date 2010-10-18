/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location;

import java.util.Set;

import org.openrdf.elmo.annotations.disjointWith;
import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.wsg84.Point;

/**
 * The Location type is used for any topic with a fixed location on the planet
 * Earth. 
 * It includes geographic features such as oceans and mountains, political entities 
 * like cities and man-made objects like buildings.
 * <ul>
 *     <li>contains and contained by: these properties can be used to show spatial
 *      relationships between different locations, such as an island contained by 
 *      a body of water (which is equivalent to saying the body of water contains 
 *      the island), a state contained by a country, a mountain within the 
 *      borders of a national park, etc. For geopolitical locations,   
 *      containment two levels up and down is the ideal minimum. For example, 
 *      the next two levels up for the city of Detroit are Wayne County and 
 *      the state of Michigan.</li>
 *      <li>adjoins: also used to show spatial relations, in this case between 
 *        locations that share a border.</li>
 * </ul>
 * 
 * @author Juan F. Codagnone
 * @since Nov 22, 2009
 */
@rdf(LocationNamespaceUtils.TYPE_LOCATION)
@disjointWith(Point.class)
public interface Location extends Topic {

    /** 
     * @return the longitude and latitude (in decimal notation) of the
     * feature, or of the geographical center (centroid) fo the feature.
     */
    @rdf(LocationNamespaceUtils.LOCATION_GEOLOCATION)
    Point getGeoLocation();
    
    
    /** Other locations within the boundaries of this location.  */
    @rdf(LocationNamespaceUtils.LOCATION_CONTAINS)
    @inverseOf(LocationNamespaceUtils.LOCATION_CONTAINEDBY)
    Set<Location> getContains();
    
    
    /** Other locations that this falls within the boundaries of.  */
    @rdf(LocationNamespaceUtils.LOCATION_CONTAINEDBY)
    @inverseOf(LocationNamespaceUtils.LOCATION_CONTAINS)
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
