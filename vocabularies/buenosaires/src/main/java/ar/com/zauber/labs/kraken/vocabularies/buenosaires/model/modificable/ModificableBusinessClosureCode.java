/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.BusinessClosureCode;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;

/**
 * {@link BusinessClosureCode} modificable
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(NamespaceUtils.TYPE_BUSINESS_CLOSURE_CODE)
public interface ModificableBusinessClosureCode extends BusinessClosureCode {
    /** @see BusinessClosureCode#getId() */
    void setId(long id);

    /** @see BusinessClosureCode#getName() */
    void setDescription(String reason);
    
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @return el identificador de la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE_ID)
    long getId();

    /** @return un texto en humano sobre la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE_DESCRIPTION)
    String getDescription();
    
}
