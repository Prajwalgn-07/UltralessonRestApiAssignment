import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

public class CreateUserNegativeTests {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }

    @Test
    public void shouldAllowToCreateUserWithInvalidEmail(){
        //1.Arrange
        CreateUserRequestBody createUserRequestBody= CreateUserRequestBody
                                                            .builder()
                                                            .name("Tenali Ramakrishna").email("tenali.ramakrishna15c.com")
                                                            .status("active").gender("male")
                                                            .build();
        //2.Act
        usersClient.CreateUser(createUserRequestBody)
                .then()
                .log()
                .body()
        //3. Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
