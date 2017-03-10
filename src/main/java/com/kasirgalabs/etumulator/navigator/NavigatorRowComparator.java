/*
 * Copyright (C) 2017 Kasirgalabs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.kasirgalabs.etumulator.navigator;

import java.util.Comparator;

public class NavigatorRowComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.contains("r")) {
            if(Integer.parseInt(o1.substring(1)) < Integer.parseInt(o2.substring(1))) {
                return -1;
            }
            return 1;
        }
        return Integer.parseInt(o1) < Integer.parseInt(o2) ? -1 : 1;
    }
}
