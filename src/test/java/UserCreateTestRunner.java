import com.github.javafaker.Faker;
import config.UserModel;
import io.restassured.path.json.JsonPath;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserCreateTestRunner {
    @Test(priority = 1, description = "Create customer 1 user")
    public void createUser1() throws IOException, ConfigurationException, ParseException {
        UserController userController=new UserController ();
        Faker faker=new Faker ();
        String name=faker.name ().fullName ();
        String email=faker.name ().firstName ().toLowerCase ()+"@test.com";
        String password= faker.number ().digits (4);
        String phone_number="01305"+Utils.generateRandom (100000,999999);
        String nid = faker.number ().digits (10);
        String role="Customer";

        UserModel model=new UserModel ();
        model.setName (name);
        model.setEmail (email);
        model.setPassword (password);
        model.setPhone_number (phone_number);
        model.setNid (nid);
        model.setRole (role);
        JsonPath jsonObj= userController.createUser (model);

        String Name=jsonObj.get ("user.name");
        String Email=jsonObj.get ("user.email");
        String Password=jsonObj.get ("user.password");
        String Phone = jsonObj.get ("user.phone_number");
        String Nid = jsonObj.get ("user.nid");
        String Role=jsonObj.get ("role");

        Utils.setEnVar ("Customer1Name", Name);
        Utils.setEnVar ("Customer1Email", Email);
        Utils.setEnVar ("Customer1Password",Password);
        Utils.setEnVar ("Customer1Phone", Phone);
        Utils.setEnVar ("Customer1Nid", Nid);
        Utils.setEnVar ("Customer1Role", Role);

        Utils.saveUsers (model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "User created";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
    @Test(priority = 2, description = "Create Customer 2 user")
    public void createUser2() throws IOException, ConfigurationException, ParseException {
        UserController userController=new UserController ();
        Faker faker=new Faker ();
        String name=faker.name ().fullName ();
        String email=faker.name ().firstName ().toLowerCase ()+"@test.com";
        String password=faker.number ().digits (4);
        String phone_number="01305"+Utils.generateRandom (100000,999999);
        String nid="14675321";
        String role="Customer";

        UserModel model=new UserModel ();
        model.setName (name);
        model.setEmail (email);
        model.setPassword (password);
        model.setPhone_number (phone_number);
        model.setNid (nid);
        model.setRole (role);
        JsonPath jsonObj= userController.createUser (model);

        String Name=jsonObj.get ("user.name");
        String Email=jsonObj.get ("user.email");
        String Password=jsonObj.get ("user.password");
        String Phone = jsonObj.get ("user.phone_number");
        String Nid = jsonObj.get ("user.nid");
        String Role=jsonObj.get ("role");

        Utils.setEnVar ("Customer2Name", Name);
        Utils.setEnVar ("Customer2Email", Email);
        Utils.setEnVar ("Customer2Password",Password);
        Utils.setEnVar ("Customer2Phone", Phone);
        Utils.setEnVar ("Customer2Nid", Nid);
        Utils.setEnVar ("Customer2Role", Role);

        Utils.saveUsers (model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "User created";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
@Test(priority = 3, description = "Create an agent")
    public void createAgent() throws IOException, ConfigurationException, ParseException {
        UserController userController=new UserController ();
        Faker faker=new Faker ();
        String name=faker.name ().fullName ();
        String email=faker.name ().firstName ().toLowerCase ()+"@test.com";
        String password=faker.number ().digits (4);
        String phone_number="01305"+Utils.generateRandom (100000,999999);
        String nid="14675321";
        String role="Agent";

        UserModel model=new UserModel ();
        model.setName (name);
        model.setEmail (email);
        model.setPassword (password);
        model.setPhone_number (phone_number);
        model.setNid (nid);
        model.setRole (role);
        JsonPath jsonObj= userController.createUser (model);
        String Name=jsonObj.get ("user.name");
        String Email=jsonObj.get ("user.email");
        String Password=jsonObj.get ("user.password");
        String PhoneNumber = jsonObj.get ("user.phone_number");
        String Nid = jsonObj.get ("user.nid");
        String Role=jsonObj.get ("role");

        Utils.setEnVar ("AgentName", Name);
        Utils.setEnVar ("AgentEmail", Email);
        Utils.setEnVar ("AgentPassword",Password);
        Utils.setEnVar ("AgentPhoneNumber", PhoneNumber);
        Utils.setEnVar ("AgentNid", Nid);
        Utils.setEnVar ("AgentRole", Role);

        Utils.saveUsers (model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "User created";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
    @Test(priority = 4, description = "Create an agent")
    public void createMerchant() throws IOException, ConfigurationException, ParseException {
        UserController userController=new UserController ();
        Faker faker=new Faker ();
        String name=faker.name ().fullName ();
        String email=faker.name ().firstName ().toLowerCase ()+"@test.com";
        String password=faker.number ().digits (4);
        String phone_number="01305"+Utils.generateRandom (100000,999999);
        String nid="14675321";
        String role="Merchant";

        UserModel model=new UserModel ();
        model.setName (name);
        model.setEmail (email);
        model.setPassword (password);
        model.setPhone_number (phone_number);
        model.setNid (nid);
        model.setRole (role);
        JsonPath jsonObj= userController.createUser (model);

        String PhoneNumber = jsonObj.get ("user.phone_number");



        Utils.setEnVar ("MerchantPhoneNumber", PhoneNumber);

        Utils.saveUsers (model);

        String messageActual = jsonObj.get("message");
        String messageExpected = "User created";
        Assert.assertTrue(messageActual.contains(messageExpected));
    }
}
