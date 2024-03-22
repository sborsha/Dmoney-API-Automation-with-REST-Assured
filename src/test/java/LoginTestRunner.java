import io.restassured.path.json.JsonPath;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner {
    @Test(description = "Admin can login")
    public void doLogin() throws IOException, ConfigurationException {
        UserController userController = new UserController ();
        JsonPath jsonObj = userController.doAdminLogin("salman@roadtocareer.net","1234");
        String messageActual = jsonObj.get("message");
        String messageExpected = "Login successfully";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
}
