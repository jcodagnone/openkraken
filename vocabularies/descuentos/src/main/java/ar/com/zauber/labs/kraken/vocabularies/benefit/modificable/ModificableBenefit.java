/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.benefit.modificable;

import java.util.Date;
import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.benefit.Benefit;
import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitNamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.benefit.BenefitType;
import ar.com.zauber.labs.kraken.vocabularies.benefit.Requisite;
import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;


/**
 * Beneficio Modificable
 *
 * @author Mariano Semelman
 * @since Nov 26, 2009
 */
@rdf(BenefitNamespaceUtils.TYPE_BENEFIT)
public interface ModificableBenefit extends Benefit {

    /** cambia la descripcion de este beneficio */
    @rdf("http://purl.org/dc/elements/1.1/description")
    @localized
    void setDescription(String s);


    /** setea el business location de donde es este descuento*/
    @inverseOf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
    void setBusinessLocation(BenefitBusinessLocation business);

    /** setea el tipo de beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_TYPE)
    void setType(BenefitType type);

    /** setea cuando vence este beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_EXPIRATION)
    void setExpiration(Date date);

    /** setea los requisitos de este beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_REQUISITE)
    void setRequisites(Set<Requisite> requisites);

    //XXX ELMO BUG (problemas con el proxy) (abstract Method error)
    /** @return el business location de donde es este descuento*/
    @inverseOf(BenefitNamespaceUtils.BUSINESS_LOCATION_BENEFIT)
    BenefitBusinessLocation getBusinessLocation();

    /** @return una descripcion de este descuento */
    @localized
    @rdf("http://purl.org/dc/elements/1.1/description")
    String getDescription();

    /** @return el tipo de beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_TYPE)
    BenefitType getType();

    /** @return cuando vence este beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_EXPIRATION)
    Date getExpiration();

    /** @return los requisitos de este beneficio */
    @rdf(BenefitNamespaceUtils.BENEFIT_REQUISITE)
    Set<Requisite> getRequisites();
}
