package aws.example;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JSONVerifierTest {
    
    String resourcesPath = "src/test/resources/";
    
    @Test
    void verifyJSON_Input1() {
        String path = resourcesPath + "input.json";
        JSONObject jsonObj = JSONVerifier.readJsonFile(path);
        assertFalse(JSONVerifier.verifyJSON(jsonObj));
    }
    
    @Test
    void verifyJSON_Input2() {
        String path = resourcesPath + "input2.json";
        JSONObject jsonObj = JSONVerifier.readJsonFile(path);
        assertFalse(JSONVerifier.verifyJSON(jsonObj));
    }
    
    @Test
    void verifyJSON_Input3()  {
        String path = resourcesPath + "input3.json";
        JSONObject jsonObj = JSONVerifier.readJsonFile(path);
        assertTrue(JSONVerifier.verifyJSON(jsonObj));
    }
    
    @Test
    void verifyJSON_Input4() {
        String path = resourcesPath + "input4.json";
        JSONObject jsonObj = JSONVerifier.readJsonFile(path);
        assertTrue(JSONVerifier.verifyJSON(jsonObj));
    }
    
    @Test
    void verifyJSON_Input5() {
        String path = resourcesPath + "input5.json";
        JSONObject jsonObj = JSONVerifier.readJsonFile(path);
        assertTrue(JSONVerifier.verifyJSON(jsonObj));
    }
    
    @Test
    void verifyJSON_Input6() {
        String path = resourcesPath + "input6.json";
        JSONObject jsonObj = JSONVerifier.readJsonFile(path);
        assertTrue(JSONVerifier.verifyJSON(jsonObj));
    }
}
