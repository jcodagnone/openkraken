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
package ar.com.zauber.labs.kraken.vocabularies.clublanacion;
import javax.xml.namespace.QName;

import junit.framework.Assert;

import org.junit.Test;
import org.openrdf.elmo.ElmoManager;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManagerFactory;

import ar.com.zauber.labs.kraken.vocabularies.clublanacion.modificable.ModificableCLNBenefit;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.modificable.ModificableCLNBusinessLocation;


/*
 * Copyright (c) 2009 Zauber S.A.  -- All rights reserved
 */

/**
 * Clase para probar las relaciones de elmo.
 * @author Mariano Semelman
 * @since Dec 1, 2009
 */
public class CLNRelationsTest {

    /** test */
    @Test
    public final void testRels() throws Exception {
        final SesameManagerFactory factory =
            new SesameManagerFactory(new ElmoModule());
        final ElmoManager manager = factory.createElmoManager();

        /* registro un bl de la nacion */
        ModificableCLNBusinessLocation bl = manager.designate(
                new QName(CLNNamespaceUtils.RESOURCE_LOCATION),
                ModificableCLNBusinessLocation.class);
        bl.setId(123);
        Assert.assertEquals(123, bl.getId());

        Status st = manager.designate(new QName(CLNNamespaceUtils.RESOURCE_STATUS),
                Status.class);

        ModificableCLNBenefit benefit = manager.designate(
                new QName(CLNNamespaceUtils.RESOURCE_BENEFIT_TYPE),
                ModificableCLNBenefit.class);
        benefit.setCLNBusinessLocation(bl);
        benefit.setStatus(st);
        benefit.setId(456);
        Assert.assertTrue(st.getBenefitsWithThisStatus().contains(benefit));

        int i = 0;
        for(CLNBusinessLocation l : manager.findAll(CLNBusinessLocation.class)) {
            i++;
        }
        Assert.assertEquals(1, i);
    }
}
