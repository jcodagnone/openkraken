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
package ar.com.zauber.labs.kraken.vocabularies.benefit;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.namespace.QName;

import junit.framework.Assert;

import org.junit.Test;
import org.openrdf.elmo.ElmoManager;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManagerFactory;

import ar.com.zauber.labs.kraken.vocabularies.benefit.modificable.ModificableBenefit;
import ar.com.zauber.labs.kraken.vocabularies.benefit.modificable.ModificableBenefitBusinessLocation;

/**
 * Pruebas sobre {@link ModificableBenefitBusinessLocation}
 * 
 * @author Pablo Martin Grigolatto
 * @since Sep 3, 2010
 */
public class ModificableBenefitBusinessLocationTest {

    /** prueba agregar un beneficio */
    @Test
    public final void setBenefitsTest() {
        final SesameManagerFactory factory = 
            new SesameManagerFactory(new ElmoModule());
        final ElmoManager manager = factory.createElmoManager();
        
        final String ns = "http://foo/c/";

        final ModificableBenefit mb = manager.designate(
                new QName(ns, "algunBeneficio"), 
                ModificableBenefit.class);
        Assert.assertNotNull(mb);
        
        final ModificableBenefitBusinessLocation mbl 
            = manager.designate(
                new QName(ns, "AlgunLugar"), 
                ModificableBenefitBusinessLocation.class);
        
        Set<Benefit> benefits = new TreeSet<Benefit>();
        benefits.add(mb);
        mbl.setBenefits(benefits);
        
        Assert.assertEquals(1, mbl.getBenefits().size());
    }
    
}
