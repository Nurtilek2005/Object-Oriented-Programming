package me.nurtilek2005.json;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JsonDecoder decoder = new JsonDecoder();
        Map<String, Object> data1 = new LinkedHashMap<>();
        for (int i = 1; i <= 3; i++) {
            Map<String, Object> data2 = new LinkedHashMap<>();
            for (int j = 1; j <=3; j++) {
                data2.put("j" + (j * i), j * i);
            }
            data1.put("i" + i, data2);
        }
        Json json = new Json(data1);
    }
}