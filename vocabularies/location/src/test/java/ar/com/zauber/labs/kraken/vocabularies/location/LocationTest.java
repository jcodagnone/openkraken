/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.location;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.TreeSet;

import javax.xml.namespace.QName;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openrdf.elmo.ElmoManager;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManagerFactory;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFWriter;
import org.openrdf.rio.turtle.TurtleWriter;

import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableCompany;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableIndustry;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableLocation;
import ar.com.zauber.labs.kraken.vocabularies.wsg84.Point;
import ar.com.zauber.labs.kraken.vocabularies.wsg84.SpatialThing;
import ar.com.zauber.labs.kraken.vocabularies.wsg84.utils.WSG84Utils;

/**
 * Prueba la serializacion
 * 
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */
public class LocationTest {

    /** test  */
    @Test
    public final void location() throws RepositoryException, 
                                        RDFHandlerException, IOException {
        final SesameManagerFactory factory = 
            new SesameManagerFactory(new ElmoModule());
        final ElmoManager manager = factory.createElmoManager();
        
        final String ns = "http://foo/c/";

        
        /// aqui comienza la diversión
        final ModificableLocation buenosAires = manager.designate(
                new QName(ns, "Buenos_aires"), ModificableLocation.class);
        buenosAires.setTitle("Buenos Aires");
        
        final Point p = manager.designate(WSG84Utils.getQName(ns, -54.0, -48.0), 
                Point.class);
        buenosAires.setGeoLocation(p);
        final ModificableCompany company = manager.designate(
                new QName(ns, "20-12345678-1"),
                ModificableCompany.class);
        company.setCuit("20-12345678-1");
        company.setTitle("Acme S.A.");
        
        final ModificableIndustry industry1 = manager.designate(
                new QName(ns, "4"),
                ModificableIndustry.class);
        industry1.setTitle("Cerveza");

        final ModificableIndustry industry2 = manager.designate(new QName(ns, "5"),
                ModificableIndustry.class);
        industry2.setTitle("Papas Fritas");
        

        final QName qname = new QName(ns, "123");
        final ModificableBusinessLocation l1 =  manager.designate(qname, 
                ModificableBusinessLocation.class);
        l1.setAddress("Armenia 1500");
        
        // BusinessLocation
        l1.setCompany(company);
        l1.setTitle("Antares Palermo");
        l1.setIndustry(industry1);
        l1.setSecundaryIndustry(industry2);
        
        l1.setContainedBy(new TreeSet<Location>(Arrays.asList(buenosAires)));
        buenosAires.setContains(new TreeSet<Location>(Arrays.asList(l1)));
        
        final StringWriter w = new StringWriter();
        final RDFWriter writer =  new TurtleWriter(w);
        writer.handleNamespace("loc", LocationNamespaceUtils.NS_LOCATION_BASE);
        writer.handleNamespace("geo", SpatialThing.NS);
        writer.handleNamespace("dc", "http://purl.org/dc/elements/1.1/");
        factory.getRepository().getConnection().export(writer);
        Assert.assertEquals(
                IOUtils.toString(getClass().getResourceAsStream("example.ttl")), 
                w.toString().replace("\t", "    "));
    }
}
