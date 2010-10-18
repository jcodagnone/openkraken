/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable;

import java.util.Date;

import org.openrdf.elmo.annotations.inverseOf;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.BusinessClosure;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.BusinessClosureCode;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.SaliSeguroLocation;

/**
 * {@link BusinessClosureCode} modificable
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(NamespaceUtils.TYPE_BUSINESS_CLOSURE)
public interface ModificableBusinessClosure extends BusinessClosure {

    /** @see BusinessClosure#getClosureReason() */ 
    void setClosureReason(BusinessClosureCode  code);
    
    /** @see BusinessClosure#getClosureDate() */
    void setClosureDate(Date date);

    /** @see BusinessClosure#getClosureDate() */
    void setLocation(SaliSeguroLocation location);
    
    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @see BusinessClosure#getClosureReason() */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_CODE)
    BusinessClosureCode getClosureReason();
    
    /** @see BusinessClosure#getClosureDate() */
    @rdf(NamespaceUtils.BUSINESS_CLOSURE_DATE)
    Date getClosureDate();
    
    /** lugares clausurados */
    @inverseOf(NamespaceUtils.SALI_SEGURO_LOCATION_CLOSURES)
    SaliSeguroLocation getLocation();
}
