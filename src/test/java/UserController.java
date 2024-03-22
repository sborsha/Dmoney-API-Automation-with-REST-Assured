import config.UserModel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class UserController extends Setup {
    public UserController() throws IOException {
        intiConfig ();
    }
    public JsonPath doAdminLogin(String email, String password) throws ConfigurationException, IOException {

        RestAssured.baseURI= prop.getProperty("baseUrl");
        UserModel model=new UserModel ();
        model.setEmail (email);
        model.setPassword (password);
        Response res=given().contentType ("application/json").body(model).when ().post ("/user/login")
                .then ().assertThat ().statusCode (200).extract ().response ();

        System.out.println (res.asString ());
        JsonPath jsonObj=res.jsonPath ();
        String token = jsonObj.get ("token");
        System.out.println (token);
        Utils.setEnVar ("token", token);
        return res.jsonPath ();
    }

    public JsonPath doLoginAllUsers(String email, String password){
        RestAssured.baseURI= prop.getProperty("baseUrl");
        UserModel model=new UserModel ();
        model.setEmail (email);
        model.setPassword (password);
        Response res=given().contentType ("application/json").body(model).when ().post ("/user/login")
                .then ().assertThat ().statusCode (200).extract ().response ();
        return res.jsonPath ();
    }

    public JsonPath searchUser(String userId){
        RestAssured.baseURI=prop.getProperty ("baseUrl");
        Response res=given ().contentType ("application/json")
                .header("Authorization",prop.getProperty("token") )
                .when ().get ("/user/search/id/"+userId);
        System.out.println (res.asString ());
        return res.jsonPath ();
    }

    public JsonPath createUser(UserModel model){

        RestAssured.baseURI=prop.getProperty ("baseUrl");
        Response res=given().contentType ("application/json").body(model)
                .header ("Authorization",prop.getProperty("token"))
                .header ("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .when ().post ("/user/create")
                .then ().assertThat ().statusCode (201).extract ().response ();
        System.out.println (res.asString ());
        return res.jsonPath ();
    }

    public JsonPath giveMoneyToAgent(UserModel model){
        RestAssured.baseURI=prop.getProperty ("baseUrl");
        Response res=given().contentType ("application/json").body(model)
                .header ("Authorization",prop.getProperty("token"))
                .header ("X-AUTH-SECRET-KEY", "ROADTOSDET")
                .when ().post ("/transaction/deposit");
//                .then ().assertThat ().statusCode (201).extract ().response ();
        System.out.println (res.asString ());
        return res.jsonPath ();
    }

    public JsonPath withdrawToCustomer(UserModel model) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response res = given().contentType("application/json").body(model)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/transaction/withdraw");
        System.out.println(res.asString());
        return res.jsonPath();
    }
    public JsonPath sendMoney(UserModel model) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response res = given().contentType("application/json").body(model)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/transaction/sendmoney");
        System.out.println(res.asString());
        return res.jsonPath();
    }
    public JsonPath payment(UserModel model) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response res = given().contentType("application/json").body(model)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/transaction/payment");
        System.out.println(res.asString());
        return res.jsonPath();
    }

    public JsonPath checkBalance(String phoneNumber) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        Response res = given().contentType("application/json")
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().get("transaction/balance/" + phoneNumber);
        System.out.println(res.asString());
        return res.jsonPath();
    }

}
