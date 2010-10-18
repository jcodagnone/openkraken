/*
 * Copyright (c) 2010 Zauber S.A. -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.foursquare.model;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitBusinessLocation;

/**
 * Modelo de un venue de Foursquare.
 * 
 * 
 * @author Francisco J. González Costanzó
 * @since Aug 27, 2010
 */
@rdf(FoursquareNamespaceUtils.TYPE_LOCATION)
public interface FoursquareLocation extends BenefitBusinessLocation {

    /** @return el venue id */
    @rdf(FoursquareNamespaceUtils.NS_4SQ_BUSINESS_LOCATION_ID)
    long getId();

    /** @return la URL corta del venue (4sq.com) */
    @rdf(FoursquareNamespaceUtils.NS_4SQ_SHORT_URL)
    String getShortUrl();
}
