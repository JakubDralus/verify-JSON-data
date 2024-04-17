package aws.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONVerifier {
    
    public static void main(String[] args) {
        String path = "src/test/resources/input.json";
        JSONObject jsonObj = readJsonFile(path);
        System.out.println("result: " + verifyJSON(jsonObj));
    }
    
    static JSONObject readJsonFile(String path) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(path)));
            return new JSONObject(jsonString);
        }
        catch (IOException e) {
            String errorMessage = "Error while reading JSON file: " + path;
            throw new RuntimeException(errorMessage, e);
        }
    }
    
    public static boolean verifyJSON(JSONObject jsonObj) {
        try {
            jsonObj = jsonObj.getJSONObject("Properties");
        }
        catch (JSONException ignored) {}
        try {
            jsonObj = jsonObj.getJSONObject("PolicyDocument");
        }
        catch (JSONException ignored2) {}
        
        JSONArray statements;
        try {
            statements = jsonObj.getJSONArray("Statement");
        }
        catch (JSONException ignored) {
            return true; // because resource can only be in Statement array
        }
        
        for (int i = 0; i < statements.length(); i++) {
            JSONObject statement = statements.getJSONObject(i);
            String resource = statement.getString("Resource");
//            System.out.println(statement);
            
            if (resource.equals("*")) {
                return false;
            }
        }
        return true;
    }
}
