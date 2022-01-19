
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;


public class CreateUserTests {

    @Test
    public void shouldCreateMaleUser(){
        //1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrisa@15cnfde.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //2. Act
        new UsersClient().CreateUser(body)
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
                "    \"email\": \"Lilli.Singh@15cxfde.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //2. Act
        new UsersClient().CreateUser(body)
                .then()
                    .log()
                    .body()
        //3. Assert
                    .statusCode(201)
                    .body("data.name", Matchers.equalTo("Lilli Singh"));
    }
}
