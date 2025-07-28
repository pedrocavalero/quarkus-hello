package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class Fibonacci {

    @Transactional
    public long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        
        // Check cache first
        FibonacciCache cached = FibonacciCache.findByN(n);
        if (cached != null) {
            return cached.result;
        }
        
        // Calculate if not cached
        long result = fibonacci(n);
        
        // Save to cache
        FibonacciCache cache = new FibonacciCache();
        cache.n = n;
        cache.result = result;
        cache.persist();
        
        return result;
    }

    private long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
