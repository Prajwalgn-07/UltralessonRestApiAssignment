import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    @Test
    public void shouldCreateMaleUser(){
        //1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrisa@15cxsnfde.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //2. Act
        CreateUser(body)
                .then()
                    .log()
                    .body()
        //3. Assert
                    .statusCode(201)
                    .body("data.name", Matchers.equalTo("Tenali Ramakrishna"));
    }


    @Test
    public void shouldCreateFemaleUser(){
        //1. Arrange
        String body = "{\n" +
                "    \"name\": \"Lilli Singh\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"Lilli.Singh@15cxsnfde.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //2. Act
        CreateUser(body)
                .then()
                    .log()
                    .body()
        //3. Assert
                    .statusCode(201)
                    .body("data.name", Matchers.equalTo("Lilli Singh"));
    }
    private Response CreateUser(String body) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer 92f1b99ec1ffa077f84eec8f302900934e0b28c53f72845a4e5084a4820cd35a")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }
}
