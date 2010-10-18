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
package ar.com.zauber.labs.kraken.vocabularies.wsg84;

import javax.xml.namespace.QName;

import org.junit.Assert;
import org.junit.Test;
import org.openrdf.elmo.ElmoManager;
import org.openrdf.elmo.ElmoModule;
import org.openrdf.elmo.sesame.SesameManagerFactory;

import ar.com.zauber.labs.kraken.vocabularies.wsg84.utils.WSG84Utils;

/**
 * Tests the WSG84 vocabulary
 * 
 * @author Juan F. Codagnone
 * @since Nov 21, 2009
 */
public class WSG84Test {

    /** test behaviours */
    @Test
    public final void testBehaivours() {
        final SesameManagerFactory sesameFactory =  new SesameManagerFactory(
                new ElmoModule());
        final ElmoManager manager = sesameFactory.createElmoManager();
        
        final Point point = manager.designate(new QName("http://hola"), Point.class);
        point.setLongitude(30.0);
        try {
            point.setLongitude(181.0);
            Assert.fail("must fail!");
        } catch(final IllegalArgumentException e) {
            // ok
        }
        try {
            point.setLongitude(-181.0);
            Assert.fail("must fail!");
        } catch(final IllegalArgumentException e) {
            // ok
        }
        
        point.setLatitude(45.0);
        try {
            point.setLatitude(90.5);
            Assert.fail("must fail!");
        } catch(final IllegalArgumentException e) {
            // ok
        }
        try {
            point.setLatitude(-90.5);
            Assert.fail("must fail!");
        } catch(final IllegalArgumentException e) {
            // ok
        }
        
        point.setAltitude(-43.0);
    }
    
    /** test geohashing */
    @Test
    public final  void geohash() {
        final QName q = WSG84Utils.getQName("http://foo/resources/locations/", 
                -54.0, -48.0);
        Assert.assertEquals("{http://foo/resources/locations/}4ymug9x7nymu", 
                q.toString());
        final Point p = WSG84Utils.getPoint(q);
        Assert.assertEquals(-54, p.getLatitude().intValue());
        Assert.assertEquals(-48, p.getLongitude().intValue());
    }
}
