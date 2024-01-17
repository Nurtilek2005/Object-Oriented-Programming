package me.nurtilek2005.json;

import java.util.List;
import java.util.Map;

public class JsonEncoder {

    public String encode(Map<String, Object> data) {
        return this.encode(data, 4);
    }

    public String encode(Map<String, Object> data, int indent) {
        return this.encode(data, indent, 1);
    }

    private String encode(Map<String, Object> data, int indent, int left) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        int index = 1;
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            jsonBuilder.append("\n").append(" ".repeat(indent * left));
            jsonBuilder.append("\"").append(entry.getKey()).append("\": ");

            if (entry.getValue() instanceof List) {
                List<Map<String, Object>> list = (List<Map<String, Object>>) entry.getValue();
                jsonBuilder.append(encodeList(list, indent, left + 1));
            } else if (entry.getValue() instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) entry.getValue();
                jsonBuilder.append(mapToJsonString(map, indent, left + 1));
            } else {
                jsonBuilder.append(valueToJsonString(entry.getValue()));
            }

            if (data.size() != index) {
                jsonBuilder.append(",");
            }
            index++;
        }

        jsonBuilder.append("\n").append(" ".repeat(indent * (left - 1))).append("}");
        return jsonBuilder.toString();
    }

    private String encodeList(List<Map<String, Object>> list, int indent, int left) {
        StringBuilder listBuilder = new StringBuilder();
        listBuilder.append("[");

        int index = 1;
        for (Map<String, Object> map : list) {
            listBuilder.append("\n").append(" ".repeat(indent * left));
            listBuilder.append(mapToJsonString(map, indent, left + 1));

            if (list.size() != index) {
                listBuilder.append(",");
            }
            index++;
        }

        listBuilder.append("\n").append(" ".repeat(indent * (left - 1))).append("]");
        return listBuilder.toString();
    }

    private String mapToJsonString(Map<String, Object> map, int indent, int left) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        int index = 1;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jsonBuilder.append("\n").append(" ".repeat(indent * left));
            jsonBuilder.append("\"").append(entry.getKey()).append("\": ");

            if (entry.getValue() instanceof List) {
                List<Map<String, Object>> list = (List<Map<String, Object>>) entry.getValue();
                jsonBuilder.append(encodeList(list, indent, left + 1));
            } else if (entry.getValue() instanceof Map) {
                Map<String, Object> nestedMap = (Map<String, Object>) entry.getValue();
                jsonBuilder.append(mapToJsonString(nestedMap, indent, left + 1));
            } else {
                jsonBuilder.append(valueToJsonString(entry.getValue()));
            }

            if (map.size() != index) {
                jsonBuilder.append(",");
            }
            index++;
        }

        jsonBuilder.append("\n").append(" ".repeat(indent * (left - 1))).append("}");
        return jsonBuilder.toString();
    }

    private String valueToJsonString(Object value) {
        if (value instanceof Number) {
            return value.toString();
        } else {
            return "\"" + value.toString() + "\"";
        }
    }

    private static String escapeString(String input) {
        return input
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
