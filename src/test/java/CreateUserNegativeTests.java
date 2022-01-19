import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {

    @Test
    public void shouldAllowToCreateUserWithInvalidEmail(){
        //1.Arrange
        String body="{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna15c.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //2.Act
        new UsersClient().CreateUser(body)
                .then()
                .log()
                .body()
        //3. Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
