package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FibonacciCache extends PanacheEntityBase {
    @Id
    public int n;
    public long result;
    
    public static FibonacciCache findByN(int n) {
        return findById((long) n);
    }
}
