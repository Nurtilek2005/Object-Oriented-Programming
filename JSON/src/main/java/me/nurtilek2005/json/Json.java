package me.nurtilek2005.json;

import java.util.LinkedHashMap;
import java.util.Map;

public class Json extends LinkedHashMap<String, Object> {
    public Json() {

    }

    public Json(Map<String, Object> data) {
        super(data);
    }

    public void put(String key, Json json) {
        super.put(key, json);
    }

    @Override
    public String toString() {
        JsonEncoder encoder = new JsonEncoder();
        return encoder.encode(this);
    }
}
