package me.nurtilek2005.json.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.nurtilek2005.json.JsonDecoder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class JsonDecoderTest {
    JsonDecoder jsonDecoder = new JsonDecoder();

    @Test
    void testSimpleJsonDecode() {
        StringBuilder jsonString = new StringBuilder("{");
        jsonString.append("\"first_name\":\"John\"").append(",");
        jsonString.append("\"last_name\":\"Doe\"").append(",");
        jsonString.append("\"age\":30").append("}");
        Object result = jsonDecoder.decode(jsonString.toString());
        assertInstanceOf(Map.class, result);

        Gson gson = new Gson();
        Map<String, Object> resultMap = gson.fromJson(jsonString.toString(), new TypeToken<Map<String, Object>>() {
        }.getType());

        assertEquals("John", resultMap.get("first_name"));
        assertEquals("Doe", resultMap.get("last_name"));
        assertEquals(30, ((Double) resultMap.get("age")).intValue());
    }

    @Test
    void testJsonWithArrayDecode() {
        StringBuilder jsonString = new StringBuilder("{");
        jsonString.append("\"first_name\":\"John\"").append(",");
        jsonString.append("\"last_name\":\"Doe\"").append(",");
        jsonString.append("\"age\":30").append(",");
        jsonString.append("\"books\":").append("[");
        jsonString.append("\"Hero\"").append(",");
        jsonString.append("\"Villain\"").append("]}");
        Object result = jsonDecoder.decode(jsonString.toString());
        assertInstanceOf(Map.class, result);

        Gson gson = new Gson();
        Map<String, Object> resultMap = gson.fromJson(jsonString.toString(), new TypeToken<Map<String, Object>>() {
        }.getType());

        assertEquals("John", resultMap.get("first_name"));
        assertEquals("Doe", resultMap.get("last_name"));
        assertEquals(30, ((Double) resultMap.get("age")).intValue());
        assertEquals(List.of(new String[]{"Hero", "Villain"}), resultMap.get("books"));
    }
}
