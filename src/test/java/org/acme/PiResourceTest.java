package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class PiResourceTest {

    @Test
    public void testCalculatePiWithFiveDecimals() {
        given()
            .queryParam("decimals", 5)
        .when()
            .get("/pi")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("value", equalTo("3.14159"));
    }

    @Test
    public void testCalculatePiWithTwoDecimals() {
        given()
            .queryParam("decimals", 2)
        .when()
            .get("/pi")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("value", equalTo("3.14"));
    }
}
