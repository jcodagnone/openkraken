/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;

/**
 * Información especifica sobre sali seguro
 * 
 * @author Juan F. Codagnone
 * @since Nov 19, 2009
 */
@rdf(NamespaceUtils.TYPE_SALI_SEGURO_LOCATION)
public interface SaliSeguroLocation extends BuenosAiresLocation, 
                                            BusinessLocation {
    /** @return el identificador del {@link BusinessLocation} */
    @rdf(NamespaceUtils.SALI_SEGURO_LOCATION_ID)
    long getId();
    
    /** @return la superficie de la locacion (puede ser nula) */
    @rdf(NamespaceUtils.SALI_SEGURO_LOCATION_SURFACE)
    Integer getSurface();

    /** @return la capacidad del local (puede ser nula) */
    @rdf(NamespaceUtils.SALI_SEGURO_LOCATION_CAPACITY)
    Integer getCapacity();

    /** @return el estado de habilitacion */
    @rdf(NamespaceUtils.SALI_SEGURO_LOCATION_HABILITATION_STATE)
    HabilitationState getHabilitationState();
    
    /** @return la clausura */
    @inverseOf(NamespaceUtils.BUSINESS_CLOSURE_LOCATION)
    Set<BusinessClosure> getClosures();
    
    /** Returns the clausuras. */
    @rdf(NamespaceUtils.SALI_SEGURO_LOCATION_AMOUNT_CLOSURE)
    int getAmountClosures();
}
