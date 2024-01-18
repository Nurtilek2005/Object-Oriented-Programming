package me.nurtilek2005.json.test;

import me.nurtilek2005.json.JsonEncoder;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonEncoderTest {
    JsonEncoder jsonEncoder = new JsonEncoder();

    @Test
    void testSimpleJsonEncode() {
        Map<String, Object> testData = new LinkedHashMap<>();
        testData.put("first_name", "John");
        testData.put("last_name", "Doe");
        testData.put("age", 32);
        String encodedData = jsonEncoder.encode(testData, 0);

        StringBuilder jsonString = new StringBuilder("{");
        jsonString.append("\"first_name\":\"John\"").append(",");
        jsonString.append("\"last_name\":\"Doe\"").append(",");
        jsonString.append("\"age\":32").append("}");

        assertEquals(jsonString.toString(), encodedData);
    }

    @Test
    void testJsonWithArrayEncode() {
        Map<String, Object> testData = new LinkedHashMap<>();
        testData.put("first_name", "John");
        testData.put("last_name", "Doe");
        testData.put("age", 32);
        testData.put("books", new String[]{"Hero", "Villain"});
        String encodedData = jsonEncoder.encode(testData, 0);

        StringBuilder jsonString = new StringBuilder("{");
        jsonString.append("\"first_name\":\"John\"").append(",");
        jsonString.append("\"last_name\":\"Doe\"").append(",");
        jsonString.append("\"age\":32").append(",");
        jsonString.append("\"books\":").append("[");
        jsonString.append("\"Hero\"").append(",");
        jsonString.append("\"Villain\"").append("]}");

        assertEquals(jsonString.toString(), encodedData);
    }
}
