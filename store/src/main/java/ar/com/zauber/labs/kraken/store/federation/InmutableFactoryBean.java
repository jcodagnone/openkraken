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
package ar.com.zauber.labs.kraken.store.federation;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.FactoryBean;

/**
 * TODO Descripcion de la clase. Los comenterios van en castellano.
 * 
 * 
 * @author Juan F. Codagnone
 * @since Dec 9, 2009
 * @param <T> type
 */
public class InmutableFactoryBean<T> implements FactoryBean<T> {
    private final T t;

    /** Creates the InmutableFactoryBean. */
    public InmutableFactoryBean(final T t) {
        Validate.notNull(t);
        
        this.t = t;
    }
    
    /** @see FactoryBean#getObject() */
    public final T getObject() throws Exception {
        return t;
    }

    /** @see FactoryBean#getObjectType() */
    public final Class<? extends T> getObjectType() {
        return (Class<? extends T>) t.getClass();
    }

    /** @see FactoryBean#isSingleton() */
    public final boolean isSingleton() {
        return true;
    }
}
