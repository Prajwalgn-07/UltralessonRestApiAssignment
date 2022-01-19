import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUserTests {
    @Test
    public void shouldGetAllTheComments(){
        given()
                .when()
                    .get("https://gorest.co.in/public/v1/comments")
                .then()
                    .statusCode(200)
                    .body("data", Matchers.hasSize(20))
                    .log()
                    .body();
    }
}
