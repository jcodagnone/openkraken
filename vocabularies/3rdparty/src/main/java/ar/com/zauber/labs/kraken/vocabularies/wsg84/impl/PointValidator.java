/**
 * Copyright (c) 2009-2010 Zauber S.A. <http://www.zauber.com.ar/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
