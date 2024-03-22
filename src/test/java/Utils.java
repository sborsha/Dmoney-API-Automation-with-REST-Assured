import config.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static int generateRandom(int min, int max){
        double randomId=Math.random ()*(max-min)+min;
        return (int) randomId;
    }
    public static void setEnVar(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config=new PropertiesConfiguration ("./src/test/resources/config.properties");
        config.setProperty (key, value);
        config.save ();
    }

    public static void saveUsers(UserModel userModel) throws IOException, org.json.simple.parser.ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader (fileLocation));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",userModel.getName());
        jsonObject.put("email",userModel.getEmail());
        jsonObject.put("password",userModel.getPassword());
        jsonObject.put("phone_number",userModel.getPhone_number());
        jsonObject.put("nid",userModel.getNid());
        jsonObject.put("role",userModel.getRole());

        jsonArray.add(jsonObject);

        FileWriter writer = new FileWriter(fileLocation);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }

}
