/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model;

import java.util.Date;

import org.openrdf.elmo.annotations.rdf;

/**
 * Clausura de un local
 * 
 * @author Juan F. Codagnone
 * @since Nov 21, 2009
 */
@rdf(NamespaceUtils.TYPE_BUSINESS_CLOSURE)
public interface BusinessClosure {

    /** @return la tificacionde la clausura */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE)
    BusinessClosureCode getClosureReason();
    
    /** Returns the fechaClausura. */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_DATE)
    Date getClosureDate();
    
    /** lugares clausurados */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_LOCATION)
    SaliSeguroLocation getLocation();
}
