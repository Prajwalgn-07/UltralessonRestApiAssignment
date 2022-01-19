package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public CreateUserResponse CreateUser(CreateUserRequestBody body) {
        Response response=create(body);
        CreateUserResponse createUserResponse=response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody createUserRequestBody){
        Response response=create(createUserRequestBody);
        CreateUserErrorResponse createUserErrorResponse=response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.getStatusCode());
        return createUserErrorResponse;
    }

    public Response create(CreateUserRequestBody body) {
        Response response = given()
                                .contentType(ContentType.JSON)
                                .accept(ContentType.JSON)
                                .header("Authorization", "Bearer 92f1b99ec1ffa077f84eec8f302900934e0b28c53f72845a4e5084a4820cd35a")
                                .body(body)
                            .when()
                                .post("https://gorest.co.in/public/v1/users");
        response
                .then()
                .log()
                .body();
        return response;
    }

    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v1/comments");
    }
}
