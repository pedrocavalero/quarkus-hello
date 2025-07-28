package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class FibonacciTest {

    @Inject
    Fibonacci fib;

    @Test
    public void testCalculate() {
        assertEquals(0, fib.calculate(0));
        assertEquals(1, fib.calculate(1));
        assertEquals(1, fib.calculate(2));
        assertEquals(2, fib.calculate(3));
        assertEquals(3, fib.calculate(4));
        assertEquals(5, fib.calculate(5));
        assertEquals(55, fib.calculate(10));
    }

    @Test
    public void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            fib.calculate(-1);
        });
    }
}
