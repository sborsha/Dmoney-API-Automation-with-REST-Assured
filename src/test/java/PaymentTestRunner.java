import config.UserModel;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaymentTestRunner extends Setup{
    @Test(priority = 1, description = "Customer2 can login Successfully")
    public void doLoginCustomer2() throws IOException {
        UserController userController = new UserController ();
        JsonPath jsonObj = userController.doLoginAllUsers (prop.getProperty ("Customer2Email"),prop.getProperty ("Customer2Password"));

        String messageActual = jsonObj.get("message");
        String messageExpected = "Login successfully";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
    @Test(priority = 2, description = " Successfully Payment to a merchant the recipient customer")
    public void paymentToMerchant() throws IOException {
        String from_account = prop.getProperty("Customer2Phone");
        String to_account = prop.getProperty("MerchantPhoneNumber");
        String amount = "100";

        UserController userController = new UserController();
        UserModel model = new UserModel();
        model.setFrom_account(from_account);
        model.setTo_account(to_account);
        model.setAmount(amount);
        JsonPath jsonObj =  userController.payment(model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "Payment successful";
        Assert.assertTrue(messageActual.contains(messageExpected));

    }
    @Test(priority = 3,description = "Customer can successfully check balance")
    public void checkBalance() throws IOException {
        UserController controller = new UserController();
        JsonPath jsonObj =  controller.checkBalance(prop.getProperty("Customer2Phone"));

        String messageActual = jsonObj.get("message");
        String messageExpected = "User balance";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
}
