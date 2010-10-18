/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.HabilitationState;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.SaliSeguroLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.BusinessLocation;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableBusinessLocation;

/**
 * {@link SaliSeguroLocation} que es modificable (para carga)
 * 
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(NamespaceUtils.TYPE_SALI_SEGURO_LOCATION)
public interface ModificableSaliSeguroLocation extends SaliSeguroLocation,
                   ModificableBuenosAiresLocation, ModificableBusinessLocation {

    /** @see SaliSeguroLocation#getId() */
    void setId(long  id);
    
    /** @see SaliSeguroLocation#getSurface() */
    void setSurface(Integer surface);

    /** @see SaliSeguroLocation#getCapacity() */
    void setCapacity(Integer capacity);

    /** @see SaliSeguroLocation# getHabilitationState() */
    void setHabilitationState(HabilitationState habilitationState);
    
    /** @see SaliSeguroLocation#getAmountClosures() */
    void setAmountClosures(int amountClosures);
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
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
    
    /** Returns the clausuras. */
    @rdf(NamespaceUtils.SALI_SEGURO_LOCATION_AMOUNT_CLOSURE)
    int getAmountClosures();
}
