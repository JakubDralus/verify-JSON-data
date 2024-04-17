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
    void verifyJSON_Input1() throws IOException {
        String resourcesPath = "src/test/resources/";
        String path = resourcesPath + "input.json";
        JSONObject jsonObj = readJsonFile(path);
        assertFalse(JSONVerifier.verifyJSON(jsonObj));
    }
    
    @Test
    void verifyJSON_Input2() throws IOException {
        String resourcesPath = "src/test/resources/";
        String path = resourcesPath + "input2.json";
        JSONObject jsonObj = readJsonFile(path);
        assertFalse(JSONVerifier.verifyJSON(jsonObj));
    }
    
    @Test
    void verifyJSON_Input3() throws IOException {
        String resourcesPath = "src/test/resources/";
        String path = resourcesPath + "input3.json";
        JSONObject jsonObj = readJsonFile(path);
        assertTrue(JSONVerifier.verifyJSON(jsonObj));
    }
    
    @Test
    void verifyJSON_Input4() throws IOException {
        String resourcesPath = "src/test/resources/";
        String path = resourcesPath + "input4.json";
        JSONObject jsonObj = readJsonFile(path);
        assertTrue(JSONVerifier.verifyJSON(jsonObj));
    }
    
}
