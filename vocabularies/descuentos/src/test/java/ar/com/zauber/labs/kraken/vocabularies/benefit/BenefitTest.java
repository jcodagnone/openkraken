/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.benefit;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.namespace.QName;

import org.junit.Assert;
import org.junit.Test;
import org.openrdf.elmo.ElmoManager;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManagerFactory;

import ar.com.zauber.labs.kraken.vocabularies.benefit.modificable.ModificableBenefit;


/**
 * Clase para testear el namespace de benefit
 *
 * @author Mariano Semelman
 * @since Nov 26, 2009
 */
public class BenefitTest {

    /** test del vocabulario definido */
    @Test
    public final void testBenefitNamespace() throws Exception {
        final SesameManagerFactory factory =
            new SesameManagerFactory(new ElmoModule());
        final ElmoManager manager = factory.createElmoManager();

        /* registro un requisito */
        final Requisite req =
            manager.designate(
                    new QName(TestResourceNamesUtils.RESOURCE_REQUESITE,
                            "/requisito"),
                    Requisite.class);
        final Set<Requisite> reqs = new TreeSet<Requisite>();
        reqs.add(req);

        /* registro un benefit business location*/
        final BenefitBusinessLocation business =
            manager.designate(
                    new QName(TestResourceNamesUtils.RESOURCE_LOCATION_BENEFIT,
                            "business"),
                    BenefitBusinessLocation.class);
        /* registro un type */
        final BenefitType type =
            manager.designate(new QName(TestResourceNamesUtils.RESOURCE_BENEFIT_TYPE,
                    "untipo"),
                    BenefitType.class);
        /* registro un beneficio */
        final ModificableBenefit beneficio =
            manager.designate(
                    new QName(TestResourceNamesUtils.RESOURCE_BENEFIT, "/beneficio"),
                    ModificableBenefit.class);
        beneficio.setDescription("un beneficio muy interesante");
        beneficio.setRequisites(reqs);
        //XXX elmo bug, no puedo hacer andar este metodo.
        beneficio.setBusinessLocation(business);
        beneficio.setType(type);
        Assert.assertEquals("un beneficio muy interesante",
                beneficio.getDescription());
        for(final Requisite r : reqs) {
            Assert.assertTrue(beneficio.getRequisites().contains(r));
            Assert.assertTrue(
                    r.getBenefitsWithThisRequisite().contains(beneficio));
        }
        Assert.assertTrue(type.getBenefitsWithThisType().contains(beneficio));
    }

}
