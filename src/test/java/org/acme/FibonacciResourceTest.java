package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FibonacciResourceTest {

    @Test
    public void testFibonacciEndpoint() {
        given()
          .queryParam("n", 10)
          .when().get("/fibonacci")
          .then()
             .statusCode(200)
             .body("n", is(10))
             .body("fibonacci", is(55));
    }

    @Test
    public void testFibonacciEndpointNegative() {
        given()
          .queryParam("n", -1)
          .when().get("/fibonacci")
          .then()
             .statusCode(400)
             .body("error", is("Fibonacci number cannot be negative."));
    }

    @Test
    public void testFibonacciEndpointMissingParam() {
        given()
          .when().get("/fibonacci")
          .then()
             .statusCode(400)
             .body("error", is("Query parameter 'n' is required."));
    }
} 