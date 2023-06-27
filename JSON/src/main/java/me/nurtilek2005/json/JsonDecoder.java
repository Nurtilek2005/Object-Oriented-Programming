package me.nurtilek2005.json;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonDecoder {
    public Map<String, Object> decode(String json) {
        return this.decode(json, 4);
    }

    public Map<String, Object> decode(String json, int indent) {
        return this.decode(json, indent, new LinkedHashMap<>());
    }

    private Map<String, Object> decode(String json, int indent, Map<String, Object> data) {
        /*
         *  FIXME: Исправить работу декодирования JSON строки.
         *  Есть подозрение на рекурсию.
         *  Я не смог найти ошибку.
         */
        json = json.replace("\n", "");
        json = json.replace(" ".repeat(indent), "");
        String[] jsonParts = json.split("\\{");
        for (int i = 0; i < jsonParts.length; i++) {
            String jsonPart = jsonParts[i];
            if (jsonPart.strip().length() < 1) continue;
            String[] set = jsonPart.split(",");
            String key = set[0];
            key = key.replace("\"", "");
            key = key.replace("{", "");
            key = key.replace("}", "");
            System.out.println(jsonPart);
            if (set.length == 1) {
                System.out.println("| " + key);
                data.put(key, this.decode(jsonPart));
                continue;
            }
            String value = set[1];
            value = value.replace("\"", "");
            value = value.replace("{", "");
            value = value.replace("}", "");
            data.put(key, value);
        }
        return data;
    }
}
