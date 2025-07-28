package org.acme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiServiceTest {

    private final PiService piService = new PiService();

    @Test
    public void testCalculatePiWithFiveDecimals() {
        String result = piService.calculatePi(5);
        assertEquals("3.14159", result);
    }

    @Test
    public void testCalculatePiWithTwoDecimals() {
        String result = piService.calculatePi(2);
        assertEquals("3.14", result);
    }

    @Test
    public void testCalculatePiWithZeroDecimals() {
        String result = piService.calculatePi(0);
        assertEquals("3", result);
    }

}
