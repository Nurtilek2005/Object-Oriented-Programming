package me.nurtilek2005;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class JsonDecoder {
    public Map<String, Object> decode(String json) {
        return this.decode(json, 4);
    }

    public Map<String, Object> decode(String json, int indent) {
        return this.decode(json, indent, 1, 1);
    }

    private Map<String, Object> decode(String json, int indent, int left, int index) {
        json = json.replace("\n", "");
        json = json.replace("    ", "");
        Map<String, Object> data = new LinkedHashMap<>();
        for (String part: json.split("\\{")) {
            if (part.strip().length() < 1) continue;
            if (part.contains("{")) {
                return this.decode(part, indent, 1, 1);
            }
            for (String entry: json.split(",")) {
                if (part.strip().length() < 1) continue;
                System.out.println(index + ") " + entry);
            }
            index++;
        }
        return data;
    }
}
