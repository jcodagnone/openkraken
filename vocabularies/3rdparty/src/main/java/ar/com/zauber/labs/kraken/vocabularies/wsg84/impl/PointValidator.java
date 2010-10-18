/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.wsg84.impl;

import javax.interceptor.InvocationContext;

import org.openrdf.elmo.annotations.intercepts;
import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.wsg84.Point;
import ar.com.zauber.labs.kraken.vocabularies.wsg84.utils.WSG84Utils;

/**
 * Validates {@link Point} attributes
 * 
 * @author Juan F. Codagnone
 * @since Nov 21, 2009
 */
@rdf("http://www.w3.org/2003/01/geo/wgs84_pos#Point")
public class PointValidator {
    /** @see Point#setLatitude(Double) */
    @intercepts
    public final void setLatitude(final InvocationContext ctx) throws Exception {
        WSG84Utils.validateLatitude((Double) ctx.getParameters()[0]);
        ctx.proceed();
    }
    
    /** @see Point#setLongitude(Double)   */
    @intercepts
    public final void setLongitude(final InvocationContext ctx) throws Exception {
        WSG84Utils.validateLongitude((Double) ctx.getParameters()[0]);
        ctx.proceed();
    }
    
    /** @see Point#setLatitude(Double)   */
    @intercepts
    public final void getLatitude(final InvocationContext ctx) throws Exception {
        WSG84Utils.validateLatitude((Double) ctx.proceed());
    }
    
    /** @see Point#setLongitude(Double)   */
    @intercepts
    public final void getLongitude(final InvocationContext ctx) throws Exception {
        WSG84Utils.validateLongitude((Double) ctx.proceed());
    }


}
