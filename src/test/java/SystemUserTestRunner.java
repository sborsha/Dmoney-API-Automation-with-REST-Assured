import config.UserModel;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SystemUserTestRunner extends Setup {
    @Test(description = "Give money from System account to the newly created agent")
    public void giveMoneyToagent() throws IOException {
        String from_account ="System";
        String to_account = prop.getProperty ("AgentPhoneNumber");
        String amount = "9000";

        UserController userController = new UserController ();
        UserModel model = new UserModel ();
        model.setFrom_account (from_account);
        model.setTo_account (to_account);
        model.setAmount (amount);

        JsonPath jsonObj = userController.giveMoneyToAgent (model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "Deposit successful";
        Assert.assertTrue (messageActual.contains (messageExpected));
    }
}
