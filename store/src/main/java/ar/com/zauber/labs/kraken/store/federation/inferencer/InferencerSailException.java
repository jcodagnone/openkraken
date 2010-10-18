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
package ar.com.zauber.labs.kraken.store.federation.inferencer;

import org.openrdf.sail.SailException;

/**
 * Excepciones relacionadas con {@link InferencerFederation}
 * 
 * @author Francisco J. González Costanzó
 * @since Dec 17, 2009
 */
public class InferencerSailException extends SailException {

    /** <code>serialVersionUID</code> */
    private static final long serialVersionUID = -7865270129199975984L;

    /** Creates the InferencerSailException. */
    public InferencerSailException() {
        super();
    }
    
    /** Creates the InferencerSailException. */
    public InferencerSailException(final Throwable t) {
        super(t);
    }
    
    /** Creates the InferencerSailException. */
    public InferencerSailException(final String msg) {
        super(msg);
    }
    
    /** Creates the InferencerSailException. */
    public InferencerSailException(final String msg, final Throwable t) {
        super(msg, t);
    }
}
