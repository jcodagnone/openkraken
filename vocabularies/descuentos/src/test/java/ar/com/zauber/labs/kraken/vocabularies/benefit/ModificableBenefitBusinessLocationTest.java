/*
 * Copyright (c) 2010 Zauber S.A.  -- All rights reserved
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
