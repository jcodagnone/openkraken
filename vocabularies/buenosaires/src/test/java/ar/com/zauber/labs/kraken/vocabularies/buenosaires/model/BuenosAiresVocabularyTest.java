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
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import javax.xml.namespace.QName;

import org.junit.Assert;
import org.junit.Test;
import org.openrdf.concepts.dc.DcResource;
import org.openrdf.elmo.ElmoManager;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManagerFactory;

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable.ModificableSaliSeguroIndustry;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable.ModificableSaliSeguroLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.Location;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableCompany;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableIndustry;

/**
 * Test for the buenos aires vocabulary
 * 
 * @author Juan F. Codagnone
 * @since Nov 22, 2009
 */
public class BuenosAiresVocabularyTest {

    /**  test */
    @Test
    public final void designateModel() {
        final SesameManagerFactory factory = 
            new SesameManagerFactory(new ElmoModule());
        final ElmoManager manager = factory.createElmoManager();
        

        final ModificableCompany company = manager.designate(
                new QName(NamespaceUtils.RESOURCE_COMPANY, "20-12345678-1"),
                ModificableCompany.class, DcResource.class);
        company.setCuit("20-12345678-1");
        company.setTitle("Acme S.A.");

        final ModificableSaliSeguroIndustry industry = manager.designate(
                new QName(NamespaceUtils.RESOURCE_INDUSTRY, "4"),
                ModificableSaliSeguroIndustry.class);
        industry.setId(4);
        industry.setTitle("Cerveza");
        
        final ModificableIndustry industry2 = manager.designate(
                new QName(NamespaceUtils.RESOURCE_INDUSTRY, "5"),
                ModificableIndustry.class);
        industry.setId(5);
        industry.setTitle("Papas Fritas");

        final QName qname = new QName(NamespaceUtils.RESOURCE_LOCATION, 
                "123");
        final ModificableSaliSeguroLocation l1 = 
            manager.designate(qname, ModificableSaliSeguroLocation.class);
        
        l1.setAddress("Armenia 1500");
        
        // BusinessLocation
        l1.setCompany(company);
        l1.setTitle("Antares Palermo");
        l1.setIndustry(industry);
        l1.setSecundaryIndustry(industry2);
        

        // SaliseguroLocation
        l1.setId(123);
        l1.setSurface(300);
        l1.setCapacity(250);
        
        l1.setAmountClosures(1);
        
        // BUenosAiresLocation 
        l1.setBlock("0B2");
        l1.setSection(3);
        l1.setLot("X93");
        l1.setDoorCode(31212);
        
        Assert.assertEquals("Armenia 1500", 
                manager.findAll(Location.class).iterator().next().getAddress());
    }
}
