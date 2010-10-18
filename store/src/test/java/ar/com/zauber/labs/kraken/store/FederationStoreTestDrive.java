/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.store;

import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openrdf.elmo.sesame.SesameManager;
import org.openrdf.elmo.sesame.SesameManagerFactory;
import org.openrdf.elmo.sesame.SesameQuery;

import ar.com.zauber.labs.kraken.store.federation.SesameManagerFactoryFactoryBean;
import ar.com.zauber.labs.kraken.vocabularies.location.Location;
import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;

/**
 * Test para store federado
 *
 * @author Francisco J. Gonzalez Costanzo
 * @since Nov 23, 2009
 */
public class FederationStoreTestDrive {

    private final Logger logger = Logger.getLogger(FederationStoreTestDrive.class);

    /**
     * Se conecta a 2 repos de ejemplo en Emma e inserta 2 statements. Después
     * crea un store federado y realiza queries a través del mismo para
     * comprobar que se devuelven resultados de los 2 stores.
     */
    @Test
    public final void federationTest() throws Exception {

        final String base = "http://emma.it.zauber.com.ar:8080/openrdf-sesame/"
                    + "repositories/";
        final SesameManagerFactory managerFactory =
            new SesameManagerFactoryFactoryBean(Arrays.asList(
                base + "geocoder",
                base + "sameas",
                base + "providers-flof",
                base + "providers-clublanacion",
                base + "providers-saliseguro"
        )).getObject();

        final String queryString =
            //CHECKSTYLE:ALL:OFF
            "PREFIX l:<http://kraken.zauber.com.ar/ns/2009/11/location#> "
          + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
          + "PREFIX dc:<http://purl.org/dc/elements/1.1/> "
          + "PREFIX saliseguro:<http://kraken.zauber.com.ar/ns/2009/11/saliseguro#> "
          + "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> "
          + "PREFIX clublanacion:<http://kraken.zauber.com.ar/ns/2009/11/clublanacion#> "
          + "PREFIX benefit:<http://kraken.zauber.com.ar/ns/2009/11/benefit#> "
          + "PREFIX owl:<http://www.w3.org/2002/07/owl#> "
          + "SELECT ?loc "
          + "WHERE { "
          + "?loc rdf:type l:business-location . "
          + "?loc l:location-geocode ?geo . "
          + "OPTIONAL { ?loc dc:identifier ?id } . "
          + "FILTER ( !BOUND(?id) || !regex(str(?id), \"emma\", \"i\") )"
          + "} LIMIT 200";
            //CHECKSTYLE:ALL:ON

        final SesameManager manager = managerFactory.createElmoManager();
        final SesameQuery locations = manager.createQuery(queryString);

        final Date inicio = new Date();
        final Iterator<?> it = locations.evaluate();
        int i = 0;
        while (it.hasNext()) {
            final Location location = (Location) it.next();
            logger.info(new Formatter(new StringBuilder()).format(
                    "%04d %-30s (%s)",
                    i++,
                    location.getTitle() == null ? "N/A"
                            : StringUtils.abbreviate(location.getTitle(), 30),
                    location.toString().replace(
                          LocationNamespaceUtils.RESOURCE_KRAKEN_BASE, "")
                          ));
        }
        final Date fin = new Date();
        final long secs = fin.getTime() - inicio.getTime();
        logger.info("Tardo : " + String.valueOf(secs) + "s");


    }
}
