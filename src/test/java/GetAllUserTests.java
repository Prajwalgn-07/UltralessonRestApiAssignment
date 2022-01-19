import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.getAll.GetAllUserResponse;


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
        GetAllUserResponse getAllUserResponse=usersClient.getAllUsers();
    //3.Assert
        Assert.assertEquals(getAllUserResponse.getStatusCode(),200);
        Assert.assertEquals(getAllUserResponse.getDataList().size(),20);
        Assert.assertTrue(getAllUserResponse.hasMaleUser("gender","male"));
    }
}
