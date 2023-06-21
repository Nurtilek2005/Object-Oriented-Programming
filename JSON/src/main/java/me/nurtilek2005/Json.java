package me.nurtilek2005;

import java.util.LinkedHashMap;
import java.util.Map;

public class Json {
    private Map<String, Object> data = new LinkedHashMap<>();

    public Json() {

    }

    public Json(Map<String, Object> data) {
        this.data = data;
    }

    public void put(Object value) {

    }

    public void put(Json jsonValue) {

    }

    public void put(String key, Object value) {

    }

    public void put(String key, Json jsonValue) {

    }

    public Object get(int index) {
        return new Object();
    }

    public Object get(String key) {
        return new Object();
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    @Override
    public String toString() {
        JsonEncoder encoder = new JsonEncoder();
        return encoder.encode(this.data);
    }
}
