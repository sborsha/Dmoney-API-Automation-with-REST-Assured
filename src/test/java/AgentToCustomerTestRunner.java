import config.UserModel;
import io.restassured.path.json.JsonPath;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AgentToCustomerTestRunner extends Setup {
    @Test(priority = 1, description = "Agent Can login")
    public void doLoginToAgent() throws IOException, ConfigurationException {
        UserController userController= new UserController ();
        JsonPath jsonObj = userController.doLoginAllUsers (prop.getProperty ("AgentEmail"), prop.getProperty ("AgentPassword"));

        String messageActual = jsonObj.get("message");
        String messageExpected = "Login successfully";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }

    @Test(priority = 2, description = "Deposit money to a customer from the agent account")
    public void depositMoneyToCustomer() throws IOException {
        String from_account = prop.getProperty ("AgentPhoneNumber");
        String to_account = prop.getProperty ("Customer1Phone");
        String amount= "8000";

        UserController userController= new UserController ();
        UserModel model = new UserModel ();
        model.setFrom_account (from_account);
        model.setTo_account (to_account);
        model.setAmount (amount);
        JsonPath jsonObj= userController.giveMoneyToAgent (model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "Deposit successful";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }

}
