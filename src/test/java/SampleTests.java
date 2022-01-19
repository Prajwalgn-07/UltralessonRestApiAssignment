import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTests {


    @Test
    public void shouldGetAllTheComments(){
        given()
                .when()
                    .get("https://gorest.co.in/public/v1/comments")
                .then()
                    .statusCode(200)
                    .body("data",Matchers.hasSize(20))
                    .log()
                    .body();
    }

    @Test
    public void shouldCreateUser(){
        given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization","Bearer 92f1b99ec1ffa077f84eec8f302900934e0b28c53f72845a4e5084a4820cd35a")
                    .body("{\n" +
                            "    \"name\": \"Tenali Ramakrishna\",\n" +
                            "    \"gender\": \"male\",\n" +
                            "    \"email\": \"tenali.ramakrishna@15cxsnfde.com\",\n" +
                            "    \"status\": \"active\"\n" +
                            "}")
                .when()
                    .post("https://gorest.co.in/public/v1/users")
                .then()
                    .log()
                    .body()
                    .statusCode(201)
                    .body("data.name", Matchers.equalTo("Tenali Ramakrishna"));
    }
}
