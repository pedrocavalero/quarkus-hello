package org.acme;

public class Fibonacci {

    public long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci number cannot be negative.");
        }
        if (n <= 1) {
            return n;
        }

        long fib = 1;
        long prevFib = 1;

        for (int i = 2; i < n; i++) {
            long temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
} 