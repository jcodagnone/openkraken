/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.clublanacion.modificable;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNBenefit;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNBusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.CLNNamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.clublanacion.Status;

/**
 * {@link CLNBenefit} modificable, para tests.
 * @author Mariano Semelman
 * @since Dec 1, 2009
 */
public interface ModificableCLNBenefit extends CLNBenefit {

    /**
     * setea el business location al que pertenece este benefit.
     */
    @inverseOf(CLNNamespaceUtils.TYPE_LOCATION)
    void setCLNBusinessLocation(CLNBusinessLocation business);

    /** setea el status
     * @param st
     * */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_STATUS)
    void setStatus(Status st);

    /** setea el id */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_ID)
    void setId(long id);

    //XXX elmo bug
    /** */
    @inverseOf(CLNNamespaceUtils.TYPE_LOCATION)
    CLNBusinessLocation  getCLNBusinessLocation();


    /** */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_STATUS)
    Status getStatus();

    /** @return el id */
    @rdf(CLNNamespaceUtils.CLN_BENEFIT_ID)
    long getId();

}
