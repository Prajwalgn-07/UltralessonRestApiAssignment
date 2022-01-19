package users.create.response;

import lombok.Getter;
import lombok.Setter;
import users.create.CreateUserRequestBody;

import static org.testng.AssertJUnit.assertEquals;

@Getter
public class CreateUserResponse {
    @Setter
    private int statusCode;
    private String meta;
    private Data data;

    public void assertUser(CreateUserRequestBody createUserRequestBody) {
        assertEquals(this.getStatusCode(),201);
        assertEquals(this.getData().getEmail(),createUserRequestBody.getEmail());
        assertEquals(this.getData().getName(),createUserRequestBody.getName());
        assertEquals(this.getData().getStatus(),createUserRequestBody.getStatus());
        assertEquals(this.getData().getGender(),createUserRequestBody.getGender());
    }
}
