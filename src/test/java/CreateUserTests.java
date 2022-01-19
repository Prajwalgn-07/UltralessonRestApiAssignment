
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;


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
        String name = "Tenali Ramakrishna";
        String gender = "male";
        String status = "active";
        CreateUserRequestBody createUserRequestBody=new CreateUserRequestBody(name,gender,email,status);
        //2. Act
        usersClient.CreateUser(createUserRequestBody)
                .then()
                    .log()
                    .body()
        //3. Assert
                    .statusCode(201)
                    .body("data.email", Matchers.equalTo(email));
    }


    @Test
    public void shouldCreateFemaleUser(){

        //1. Arrange
        String email=String.format("%s@gmail.com", UUID.randomUUID());
        String name = "Lilli Singh";
        String gender = "female";
        String status = "active";
        CreateUserRequestBody createUserRequestBody=new CreateUserRequestBody(name,gender,email,status);
        //2. Act
        usersClient.CreateUser(createUserRequestBody)
                .then()
                    .log()
                    .body()
        //3. Assert
                    .statusCode(201)
                    .body("data.email", Matchers.equalTo(email));
    }
}
