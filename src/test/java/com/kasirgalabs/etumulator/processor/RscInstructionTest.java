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
package com.kasirgalabs.etumulator.processor;

import static org.junit.Assert.assertEquals;

import com.kasirgalabs.etumulator.InstructionTester;
import org.junit.Test;

public class RscInstructionTest extends InstructionTester {
    /**
     * Test of exitRsc method, of class Processor.
     */
    @Test
    public void testExitRsc() {
        cpsr.setCarry(false);
        char[] code = ("rsc r1, r2, r3\n").toCharArray();
        runTestCode(code);
        assertEquals("Subtraction result is wrong.", registerFile.getValue(1), 0);

        cpsr.setCarry(true);
        code = ("rsc r0, r1, 0\n").toCharArray();
        runTestCode(code);
        assertEquals("Subtraction result is wrong.", registerFile.getValue(0), -1);

        cpsr.setCarry(false);
        code = ("rsc r0, r1, 4\n").toCharArray();
        runTestCode(code);
        assertEquals("Subtraction result is wrong.", registerFile.getValue(0), 4);

        cpsr.setCarry(true);
        code = ("mov r1, #1\n"
                + "mov r2, #2\n"
                + "rsc r0, r2, r1\n").toCharArray();
        runTestCode(code);
        assertEquals("Subtraction result is wrong.", registerFile.getValue(0), -2);

        cpsr.setCarry(true);
        code = ("mov r0, #1\n"
                + "rsc r0, r0, r0\n").toCharArray();
        runTestCode(code);
        assertEquals("Subtraction result is wrong.", registerFile.getValue(0), -1);
    }
}