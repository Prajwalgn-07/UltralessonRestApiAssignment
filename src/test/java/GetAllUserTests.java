import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;


public class GetAllUserTests {
    //1.Arrange
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void shouldGetAllTheComments(){
    //2.Act
        usersClient.getAllUsers()
                .then()
    //3.Assert
                    .statusCode(200)
                    .body("data", Matchers.hasSize(20))
                    .log()
                    .body();
    }


}
