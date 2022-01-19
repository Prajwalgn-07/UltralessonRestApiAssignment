import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import static org.testng.AssertJUnit.assertEquals;

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
           CreateUserErrorResponse createUserErrorResponse= usersClient.createUserExpectingError(createUserRequestBody);
        //3.Assert
        assertEquals(createUserErrorResponse.getStatusCode(),422);
        createUserErrorResponse.assertHasError("email","is invalid");
    }
    @Test
    public void shouldAllowToCreateUserWithBlankGenderAndStatus(){
        //1.Arrange
        CreateUserRequestBody createUserRequestBody= CreateUserRequestBody
                                                            .builder()
                                                            .name("Tenali Ramakrishna").email("tenali.ramakrishna15@cc.com")
                                                            .status("").gender("")
                                                            .build();
        //2.Act
        CreateUserErrorResponse createUserErrorResponse= usersClient.createUserExpectingError(createUserRequestBody);
        //3.Assert
        assertEquals(createUserErrorResponse.getStatusCode(),422);
        createUserErrorResponse.assertHasError("gender","can't be blank");
        createUserErrorResponse.assertHasError("status","can't be blank");
    }
}
