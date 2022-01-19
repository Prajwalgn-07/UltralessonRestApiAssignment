
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static org.testng.AssertJUnit.assertEquals;


public class CreateUserTests {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser(){
        //1. Arrange
        String email=String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody createUserRequestBody= CreateUserRequestBody
                                                            .builder()
                                                            .name("Tenali Ramakrishna").email(email)
                                                            .status("active").gender("male")
                                                            .build();
        //2. Act
        CreateUserResponse createUserResponse=usersClient.CreateUser(createUserRequestBody);
        //3. Assert
        createUserResponse.assertUser(createUserRequestBody);
    }


    @Test
    public void shouldCreateFemaleUser(){

        //1. Arrange
        String email=String.format("%s@gmail.com", UUID.randomUUID());
       CreateUserRequestBody createUserRequestBody= CreateUserRequestBody
                                                            .builder()
                                                            .name("Lilli Singh").email(email)
                                                            .status("active").gender("female")
                                                            .build();
        //2. Act
        CreateUserResponse createUserResponse=usersClient.CreateUser(createUserRequestBody);
        //3. Assert
        createUserResponse.assertUser(createUserRequestBody);
    }
}
