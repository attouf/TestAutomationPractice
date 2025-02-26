package utile;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonReader {

    public static String userSignInData (String data) throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\Data\\UserSignIn.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject existingUser = (JSONObject) obj;
        return (String)existingUser.get(data);
    }
    public static String userSignUpData (String data) throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\Data\\NewUser.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject existingUser = (JSONObject) obj;
        return (String)existingUser.get(data);
    }

}
