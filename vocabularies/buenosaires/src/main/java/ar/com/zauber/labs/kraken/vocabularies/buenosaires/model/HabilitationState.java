/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

/**
 * Estado de habilitación
 * 
 * @author Marcelo Turrin
 * @since Nov 6, 2009
 */
@rdf(NamespaceUtils.TYPE_HABILITATION_STATE)
public interface HabilitationState {

    /** Returns the id. */
    @rdf(NamespaceUtils.HABILTATION_STATE_ID)
    long getId();

        /** Returns the estado. */
    @rdf(NamespaceUtils.HABILTATION_STATE_DESCRIPTION)
    @localized
    String getDescription();
    
    /** todos los lugares que tienen este codigo de habilitacion */
    @inverseOf(NamespaceUtils.SALI_SEGURO_LOCATION_HABILITATION_STATE)
    Set<SaliSeguroLocation> getLocations();
}