/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import java.util.Set;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.localized;
import org.openrdf.elmo.annotations.rdf;

/**
 * Representa el código de una clausura de un local
 * 
 * @author Marcelo Turrin
 * @since Nov 19, 2009
 */
@rdf(NamespaceUtils.TYPE_BUSINESS_CLOSURE_CODE)
public interface BusinessClosureCode {
    
    /** @return el identificador de la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE_ID)
    long getId();

    /** @return un texto en humano sobre la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE_DESCRIPTION)
    @localized
    String getDescription();
    
    /** @return las clausuras hechas bajo este código */
    @inverseOf(NamespaceUtils.BUSINESS_CLOSURE_CODE)
    Set<BusinessClosure> getClousures();
}
