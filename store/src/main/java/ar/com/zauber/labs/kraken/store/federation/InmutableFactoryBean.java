/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
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
