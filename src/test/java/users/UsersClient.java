package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public Response CreateUser(CreateUserRequestBody body) {
        return
                given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization", "Bearer 92f1b99ec1ffa077f84eec8f302900934e0b28c53f72845a4e5084a4820cd35a")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v1/users");
    }
    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v1/comments");
    }
}
