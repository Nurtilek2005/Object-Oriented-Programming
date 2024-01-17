package me.nurtilek2005.json;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class JsonDecoder {
    public Map<String, Object> decode(String json) {
        return decode(json, 4);
    }

    public Map<String, Object> decode(String json, int indent) {
        return decode(json, indent, new LinkedHashMap<>());
    }

    private Map<String, Object> decode(String json, int indent, Map<String, Object> data) {
        Stack<Character> stack = new Stack<>();
        StringBuilder keyBuilder = new StringBuilder();
        StringBuilder valueBuilder = new StringBuilder();
        String currentKey = null;

        for (char c : json.toCharArray()) {
            if (c == '{' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ']') {
                stack.pop();
            } else if (c == ':' && stack.isEmpty()) {
                currentKey = keyBuilder.toString().trim();
                keyBuilder.setLength(0);
            } else if (c == ',' && stack.isEmpty()) {
                if (currentKey != null) {
                    Object value = parseValue(valueBuilder.toString().trim());
                    data.put(currentKey, value);
                    currentKey = null;
                    valueBuilder.setLength(0);
                }
            } else {
                if (currentKey != null) {
                    valueBuilder.append(c);
                } else {
                    keyBuilder.append(c);
                }
            }
        }

        if (currentKey != null) {
            Object value = parseValue(valueBuilder.toString().trim());
            data.put(currentKey, value);
        }

        return data;
    }

    private Object parseValue(String value) {
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        } else if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(value);
        } else {
            try {
                if (value.contains(".")) {
                    return Double.parseDouble(value);
                } else {
                    return Long.parseLong(value);
                }
            } catch (NumberFormatException e) {
                return value;
            }
        }
    }
}
