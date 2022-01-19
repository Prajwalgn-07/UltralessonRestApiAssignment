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
                    .log()
                    .body();
    }
}
