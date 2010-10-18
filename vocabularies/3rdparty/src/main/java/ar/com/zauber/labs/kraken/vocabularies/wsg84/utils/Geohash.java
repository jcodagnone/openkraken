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
/*
 * From
 * http://geospatialweb.googlecode.com/svn/trunk/geohash/src/Geohash.java
 * LGPL 
 */
package ar.com.zauber.labs.kraken.vocabularies.wsg84.utils;

import java.util.BitSet;
import java.util.HashMap;

/** http://geohash.org/ */
public class Geohash {
    private static int numbits = 6 * 5;
    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    /** lookup */
    private static final HashMap<Character, Integer> LOOKUP = 
        new HashMap<Character, Integer>();
    static {
        int i = 0;
        for (final char c : DIGITS) {
            LOOKUP.put(c, i++);
        }
    }

    /** rock & roll */
    public static void main(final String[] args) {
        double[] latlon = new Geohash().decode("dj248j248j24");
        System.out.println(latlon[0] + " " + latlon[1]);

        final Geohash e = new Geohash();
        final String s = e.encode(30, -90.0);
        System.out.println(s);
        latlon = e.decode(s);
        System.out.println(latlon[0] + ", " + latlon[1]);
    }

    /** decode a geohash */
    public final double[] decode(final String geohash) {
        final StringBuilder buffer = new StringBuilder();
        for (final char c : geohash.toCharArray()) {

            final int i = LOOKUP.get(c) + 32;
            buffer.append(Integer.toString(i, 2).substring(1));
        }

        final BitSet lonset = new BitSet();
        final BitSet latset = new BitSet();

        // even bits
        int j = 0;
        for (int i = 0; i < numbits * 2; i += 2) {
            boolean isSet = false;
            if (i < buffer.length()) {
                isSet = buffer.charAt(i) == '1';
            }
            lonset.set(j++, isSet);
        }

        // odd bits
        j = 0;
        for (int i = 1; i < numbits * 2; i += 2) {
            boolean isSet = false;
            if (i < buffer.length()) {
                isSet = buffer.charAt(i) == '1';
            }
            latset.set(j++, isSet);
        }

        final double lon = decode(lonset, -180, 180);
        final double lat = decode(latset, -90, 90);

        return new double[] {lat, lon};
    }

    /** decode a geohash */
    private double decode(final BitSet bs, double floor, double ceiling) {
        double mid = 0;
        for (int i = 0; i < bs.length(); i++) {
            mid = (floor + ceiling) / 2;
            if (bs.get(i)) {
                floor = mid;
            } else {
                ceiling = mid;
            }
        }
        return mid;
    }

    /** encode geohash */
    public final String encode(final double lat, final double lon) {
        final BitSet latbits = getBits(lat, -90, 90);
        final BitSet lonbits = getBits(lon, -180, 180);
        final StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < numbits; i++) {
            buffer.append((lonbits.get(i)) ? '1' : '0');
            buffer.append((latbits.get(i)) ? '1' : '0');
        }
        return base32(Long.parseLong(buffer.toString(), 2));
    }

    /** TODO document */
    private BitSet getBits(final double lat, double floor, double ceiling) {
        final BitSet buffer = new BitSet(numbits);
        for (int i = 0; i < numbits; i++) {
            final double mid = (floor + ceiling) / 2;
            if (lat >= mid) {
                buffer.set(i);
                floor = mid;
            } else {
                ceiling = mid;
            }
        }
        return buffer;
    }

    /** base32 */
    public static String base32(long i) {
        final char[] buf = new char[65];
        int charPos = 64;
        final boolean negative = (i < 0);
        if (!negative) {
            i = -i;
        }
        while (i <= -32) {
            buf[charPos--] = DIGITS[(int) (-(i % 32))];
            i /= 32;
        }
        buf[charPos] = DIGITS[(int) (-i)];

        if (negative) {
            buf[--charPos] = '-';
        }
        return new String(buf, charPos, (65 - charPos));
    }

}
