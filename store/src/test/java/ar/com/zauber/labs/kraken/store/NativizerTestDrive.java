/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.store;

import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openrdf.elmo.sesame.SesameManager;
import org.openrdf.elmo.sesame.SesameManagerFactory;
import org.openrdf.elmo.sesame.SesameQuery;
import org.openrdf.query.QueryLanguage;

import ar.com.zauber.labs.kraken.store.federation.Nativizer;
import ar.com.zauber.labs.kraken.vocabularies.location.Location;
import ar.com.zauber.labs.kraken.vocabularies.location.LocationNamespaceUtils;


/**
 * Test de Nativizer
 *
 *
 * @author Mariano Semelman
 * @since Jan 6, 2010
 */
public class NativizerTestDrive {

    private final Logger logger = Logger.getLogger(NativizerTestDrive.class);

    /** */
    @Test
    public final void init() throws Exception {
        final String base = "http://emma.it.zauber.com.ar:8080/openrdf-sesame/"
            + "repositories/";
        final List<String> list = Arrays.asList(
            base + "geocoder",
            base + "sameas",
            base + "providers-flof",
            base + "providers-clublanacion",
            base + "providers-saliseguro",
            base + "vocabularies"
        );
        final Nativizer nativo = new Nativizer(list);
        nativo.getObject();
        nativo.destroy();
    }

    /** */
    @Test
    public final void buscarNoGeocodificados() throws Exception {

        final String base = "http://emma.it.zauber.com.ar:8080/openrdf-sesame/"
            + "repositories/";
        final List<String> list = Arrays.asList(
                base + "geocoder",
//            base + "sameas",
//            base + "providers-flof",
                base + "providers-clublanacion",
//            base + "providers-saliseguro",
                base + "vocabularies"
        );
        final Nativizer nativo = new Nativizer(list);
        final SesameManagerFactory managerFactory = nativo.getObject();
        managerFactory.setQueryLanguage(QueryLanguage.SERQL);
        final SesameManager manager = managerFactory.createElmoManager();
        final String query = "select location "
        + "from {location} rdf:type {l:location}; "
        + " l:location-address {address}; "
        + " l:location-geocode {geocode} "
//        + " where not bound(geocode) "
        + " USING NAMESPACE "
        + " dc = <http://purl.org/dc/elements/1.1/>, "
        + " rdf = <http://www.w3.org/1999/02/22-rdf-syntax-ns#>, "
        + " l = <http://kraken.zauber.com.ar/ns/2009/11/location#> ";


        final Date inicio = new Date();
        try {
            final SesameQuery locations = manager.createQuery(query);

            final Iterator<?> result = locations.evaluate();

            while(result.hasNext()) {
                final Location location = (Location)result.next();
                System.out.println(location.getAddress());
                if(!location.getContainedBy().isEmpty()) {
                    System.out.println(
                            location.getContainedBy().iterator().next().getTitle());
                }
            }
        } catch (final Exception e) {
            throw new RuntimeException("Se produjo un error consultando el repo", e);
        }
        final Date fin = new Date();
        final long secs = fin.getTime() - inicio.getTime();
        logger.info("Tardo : " + String.valueOf(secs) + "ms");
        nativo.destroy();
    }

    /** */
    @Test
    public final void competenciaFederalizacion() throws Exception {

        final String base = "http://emma.it.zauber.com.ar:8080/openrdf-sesame/"
            + "repositories/";
        final List<String> list = Arrays.asList(
                base + "geocoder",
                base + "sameas",
                base + "providers-flof",
                base + "providers-clublanacion",
                base + "providers-saliseguro",
                base + "vocabularies"
        );
        final Nativizer nativo = new Nativizer(list);
        final SesameManagerFactory managerFactory = nativo.getObject();
        managerFactory.setQueryLanguage(QueryLanguage.SPARQL);
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
          + "?loc rdf:type l:location . "
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
        logger.info("Tardo : " + String.valueOf(secs) + "ms");
        nativo.destroy();
    }


}
