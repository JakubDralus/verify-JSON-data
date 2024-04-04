package aws.example;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JSONVerifierTest {
    private static JSONObject readJsonFile(String path) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(path)));
        return new JSONObject(jsonString);
    }
    @Test
    void verifyJSON() throws IOException {
        String resourcesPath = "src/test/resources/";
        String path;
        JSONObject jsonObj;
        
        path = resourcesPath + "input.json";
        jsonObj = readJsonFile(path);
        assertFalse(JSONVerifier.verifyJSON(jsonObj));
        
        path = resourcesPath + "input2.json";
        jsonObj = readJsonFile(path);
        assertFalse(JSONVerifier.verifyJSON(jsonObj));
        
        path = resourcesPath + "input3.json";
        jsonObj = readJsonFile(path);
        assertTrue(JSONVerifier.verifyJSON(jsonObj));
        
        path = resourcesPath + "input4.json";
        jsonObj = readJsonFile(path);
        assertTrue(JSONVerifier.verifyJSON(jsonObj));
    }
}
