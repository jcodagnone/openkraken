/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.SaliSeguroIndustry;
import ar.com.zauber.labs.kraken.vocabularies.location.Industry;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableIndustry;

/**
 * Modificable {@link SaliSeguroIndustry}
 * 
 * @author Juan F. Codagnone
 * @since Nov 23, 2009
 */
@rdf(NamespaceUtils.TYPE_SALI_SEGURO_INDUSTRY)
public interface ModificableSaliSeguroIndustry extends SaliSeguroIndustry,
                                                       ModificableIndustry {

    /** @see Industry#getId() */
    void setId(long id);
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @return el identificador de este rubro */
    @rdf(NamespaceUtils.INDUSTRY_ID)
    long getId();
    
}
