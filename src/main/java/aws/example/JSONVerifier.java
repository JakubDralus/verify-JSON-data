package aws.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONVerifier {
    
    public static void main(String[] args) {
        try {
            String path = "src/test/resources/input.json";
            JSONObject jsonObj = readJsonFile(path);
            System.out.println("result: " + verifyJSON(jsonObj));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static JSONObject readJsonFile(String path) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(path)));
        return new JSONObject(jsonString);
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
        
        JSONArray statements = jsonObj.getJSONArray("Statement");
        
        for (int i = 0; i < statements.length(); i++) {
            JSONObject statement = statements.getJSONObject(i);
            String resource = statement.getString("Resource");
//            System.out.println(statement);
            
            if ("*".equals(resource)) {
                return false;
            }
        }
        return true;
    }
}
