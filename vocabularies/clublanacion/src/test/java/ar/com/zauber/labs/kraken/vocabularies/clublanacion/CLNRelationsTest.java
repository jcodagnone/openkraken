/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
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
