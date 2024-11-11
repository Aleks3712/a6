package test;

import io.restassured.RestAssured;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

@Listeners(TestListener.class)
public class StatusCodeTest {

    @Test
    public void testGoogleHomePageStatusCode() {
        RestAssured.baseURI = "https://www.google.com";
        given()
                .when().get("/")
                .then()
                .statusCode(404); //ошибочный тест для скриншота
    }
}
