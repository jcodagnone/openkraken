/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.HabilitationState;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;

/**
 * {@link HabilitationState} que es modificable (para carga)
 * 
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(NamespaceUtils.TYPE_HABILITATION_STATE)
public interface ModificableHabilitationState extends HabilitationState {

    /** @see HabilitationState#getId() */
    void setId(long id);

    /** Returns the estado. */
    @rdf(NamespaceUtils.HABILTATION_STATE_DESCRIPTION)
    void setDescription(String description);
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** Returns the id. */
    @rdf(NamespaceUtils.HABILTATION_STATE_ID)
    long getId();

        /** Returns the estado. */
    @rdf(NamespaceUtils.HABILTATION_STATE_DESCRIPTION)
    String getDescription();
}
