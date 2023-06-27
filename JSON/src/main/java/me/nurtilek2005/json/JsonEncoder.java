package me.nurtilek2005.json;

import java.util.Map;

public class JsonEncoder {
    public String encode(Map<String, Object> data) {
        return this.encode(data, 4);
    }

    public String encode(Map<String, Object> data, int indent) {
        return this.encode(data, indent, 1, 1);
    }

    private String encode(Map<String, Object> data, int indent, int left, int index) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if (entry.getValue() instanceof Map) {
                Map<String, Object> entryData = (Map<String, Object>) entry.getValue();
                String encoded = this.encode(entryData, indent, left + 1, 1);
                result.append("\n").append(" ".repeat(indent * left));
                result.append("\"" + entry.getKey() + "\": ");
                result.append(encoded);
                if (data.size() != index) {
                    result.append(",");
                }
                index++;
                continue;
            }
            result.append("\n").append(" ".repeat(indent * left));
            result.append("\"" + entry.getKey() + "\": ");
            try {
                Integer.parseInt(entry.getValue().toString());
                Double.parseDouble(entry.getValue().toString());
                Float.parseFloat(entry.getValue().toString());
                result.append(entry.getValue().toString());
            } catch (NumberFormatException exception) {
                result.append("\"" + entry.getValue().toString() + "\"");
            }
            if (data.size() != index) {
                result.append(",");
            }
            index++;
        }
        result.append("\n").append(" ".repeat(indent * (left - 1))).append("}");
        return result.toString();
    }
}
