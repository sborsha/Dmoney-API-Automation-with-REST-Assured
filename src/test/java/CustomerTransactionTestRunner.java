import config.UserModel;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerTransactionTestRunner extends Setup {
    @Test(priority = 1, description = "Customer1 can login Successfully")
    public void doLoginCustomer() throws IOException {
        UserController userController = new UserController ();
        JsonPath jsonObj = userController.doLoginAllUsers (prop.getProperty ("Customer1Email"),prop.getProperty ("Customer1Password"));

        String messageActual = jsonObj.get("message");
        String messageExpected = "Login successfully";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
    @Test(priority = 2, description = "Withdraw by the customer to the agent")
    public void MoneyWithdrawToAgent() throws IOException {
        String from_account = prop.getProperty ("Customer1Phone");
        String to_account = prop.getProperty ("AgentPhoneNumber");
        String amount = "500";

        UserController userController = new UserController ();
        UserModel model = new UserModel ();
        model.setFrom_account (from_account);
        model.setTo_account (to_account);
        model.setAmount (amount);
        JsonPath jsonObj = userController.withdrawToCustomer (model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "Withdraw successful";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
    @Test(priority = 3, description = "Send money to another customer")
    public void sendMoneyTOAnotherCustomer() throws IOException {
        String from_account = prop.getProperty("Customer1Phone");
        String to_account = prop.getProperty("Customer2Phone");
        String amount = "2000";

        UserController userController = new UserController();
        UserModel model = new UserModel();
        model.setFrom_account(from_account);
        model.setTo_account(to_account);
        model.setAmount(amount);
        JsonPath jsonObj = userController.sendMoney(model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "Send money successful";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
}
