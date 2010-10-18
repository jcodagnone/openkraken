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
