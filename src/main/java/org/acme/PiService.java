package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PiService {

    public String calculatePi(int decimals) {
        return String.format("%." + decimals + "f", Math.PI);
    }
}
