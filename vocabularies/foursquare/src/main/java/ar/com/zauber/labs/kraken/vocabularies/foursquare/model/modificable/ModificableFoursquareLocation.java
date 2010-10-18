/*
 * Copyright (c) 2010 Zauber S.A. -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.foursquare.model.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.benefit.modificable.ModificableBenefitBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.foursquare.model.FoursquareLocation;
import ar.com.zauber.labs.kraken.vocabularies.foursquare.model.FoursquareNamespaceUtils;

/**
 * Setters para {@link FoursquareLocation}
 * 
 * 
 * @author Francisco J. González Costanzó
 * @since Aug 27, 2010
 */
@rdf(FoursquareNamespaceUtils.TYPE_LOCATION)
public interface ModificableFoursquareLocation extends FoursquareLocation,
        ModificableBenefitBusinessLocation {

    /** Setea el id */
    void setId(long id);

    /** Setea la short URL */
    void setShortUrl(String shortUrl);

    // XXX elmo bug
    /** @return el venue id */
    @rdf(FoursquareNamespaceUtils.NS_4SQ_BUSINESS_LOCATION_ID)
    long getId();

    /** @return la URL corta del venue (4sq.com) */
    @rdf(FoursquareNamespaceUtils.NS_4SQ_SHORT_URL)
    String getShortUrl();

}
