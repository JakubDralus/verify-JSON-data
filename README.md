# Remitly Internship 2024 Home exercise

This project is set to compile in java 17. <br> 
*(see pom.xml)*

## How to 

run project:
```bash
mvn exec:java
```

run tests:
```bash
mvn test
```

## Input Format

One format is `AWS::IAM::Role Policy` which has a `"PolicyDocument"`
obj and on the second layer is `"Statement"` array.
```json
{
  "PolicyDocument" : Json,
  "PolicyName" : String
}
```

But the second format is named `AWS::IAM::RolePolicy` (without space) which
has one more layer `"Properties"` on top of the previous structure.
```json
{
  "Type" : "AWS::IAM::RolePolicy",
  "Properties" : {
      "PolicyDocument" : Json,
      "PolicyName" : String,
      "RoleName" : String
    }
}
```
So I decided to **cover both** of the approaches.

## Approach

Having different number of layers in the input json file i'm first checking 
if there is `"Properties"` if not I check if the `"PolicyDocument"` is present.

```java
try {
    jsonObj = jsonObj.getJSONObject("Properties");
}
catch (JSONException ignored) {}
try {
    jsonObj = jsonObj.getJSONObject("PolicyDocument");
}
catch (JSONException ignored2) {}
```
therefore the jsonObj variable will have proper object in it,
covering every scenario.

Finally, I search the `"Statement"` array for the resource and check if it has `"*"`.

```java
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
    
    if (resource.equals("*")) {
        return false;
    }
}
return true;
```

## Dependencies

```xml
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20240303</version>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
</dependency>
```
