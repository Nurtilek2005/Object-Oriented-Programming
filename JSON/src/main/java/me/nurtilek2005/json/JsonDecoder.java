package me.nurtilek2005.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDecoder {

    private final ObjectMapper objectMapper;

    public JsonDecoder() {
        this.objectMapper = new ObjectMapper();
    }

    public Object decode(String json) {
        return decode(json, 4);
    }

    public Object decode(String json, int indent) {
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            return convertJsonNode(jsonNode, indent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Object convertJsonNode(JsonNode jsonNode, int indent) {
        if (jsonNode.isObject()) {
            Map<String, Object> map = new HashMap<>();
            jsonNode.fields().forEachRemaining(entry -> map.put(entry.getKey(), convertJsonNode(entry.getValue(), indent)));
            return map;
        } else if (jsonNode.isArray()) {
            List<Object> list = new ArrayList<>();
            jsonNode.elements().forEachRemaining(element -> list.add(convertJsonNode(element, indent)));
            return list;
        } else {
            return convertJsonValue(jsonNode, indent);
        }
    }

    private Object convertJsonValue(JsonNode jsonNode, int indent) {
        switch (jsonNode.getNodeType()) {
            case BOOLEAN:
                return jsonNode.asBoolean();
            case NUMBER:
                if (jsonNode.isFloatingPointNumber()) {
                    return jsonNode.asDouble();
                } else {
                    return jsonNode.asLong();
                }
            case STRING:
                return jsonNode.asText();
            case NULL:
            default:
                return null;
        }
    }
}
