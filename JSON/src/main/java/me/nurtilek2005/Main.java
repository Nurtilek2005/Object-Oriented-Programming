package me.nurtilek2005;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> data1 = new LinkedHashMap<>();
        for (int i = 1; i <= 3; i++) {
            Map<String, Object> data2 = new LinkedHashMap<>();
            for (int j = 4; j <= 7; j++) {
                Map<String, Object> data3 = new LinkedHashMap<>();
                for (int k = 8; k <= 14; k++) {
                    data3.put("k - " + k, k);
                }
                data2.put("j - " + j, data3);
            }
            data1.put("i - " + i, data2);
        }
        Json json = new Json(data1);
        System.out.println(json);
    }
}