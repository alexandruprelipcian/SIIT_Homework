package org.siit.homework.week6;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ExpressionTest {
    @Test
    public void testCmToMmConversion() {
        assertEquals(10, Calculator.cmToMm(1.0));
    }

    @Test
    public void testDmToMmConversion() {
        assertEquals(100, Calculator.dmToMm(1.0));
    }

    @Test
    public void testMToMmConversion() {
        assertEquals(1000, Calculator.mToMm(1.0));
    }

    @Test
    public void testKmToMmConversion() {
        assertEquals(1000000, Calculator.kmToMm(1.0));
    }

    @Test
    public void testCalculateExpression() {
        String input = "10 cm + 20 cm";
        String[] expression = input.split(" ");
        assertEquals(300, Calculator.calculateExpression(expression));
    }

    @Test
    public void testCalculateExpressionValid() {
        String input = "10";
        String[] expression = input.split(" ");
        assertNull(Calculator.calculateExpression(expression));
    }
}
