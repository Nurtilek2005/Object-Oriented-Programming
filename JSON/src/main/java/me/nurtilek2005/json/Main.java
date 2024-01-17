package me.nurtilek2005.json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JsonEncoder encoder = new JsonEncoder();

        Map<String, Object> data1 = new LinkedHashMap<>();
        for (int i = 1; i <= 3; i++) {
            List<Map<String, Object>> list = new ArrayList<>();
            Map<String, Object> data2 = new LinkedHashMap<>();
            for (int j = 1; j <= 3; j++) {
                Map<String, Object> data5 = new LinkedHashMap<>();
                for (int k = 1; k <= 3; k++) {
                    data5.put("k" + (k * i), k * i);
                }
                data2.put("j" + (j * i), data5);
            }
            list.add(data2);

            Map<String, Object> data3 = new LinkedHashMap<>();
            for (int j = 1; j <= 3; j++) {
                Map<String, Object> data5 = new LinkedHashMap<>();
                for (int k = 1; k <= 3; k++) {
                    data5.put("k" + (k * i), k * i);
                }
                data3.put("j" + (j * i), data5);
            }
            list.add(data3);
            Map<String, Object> data4 = new LinkedHashMap<>();
            for (int j = 1; j <= 3; j++) {
                Map<String, Object> data5 = new LinkedHashMap<>();
                for (int k = 1; k <= 3; k++) {
                    data5.put("k" + (k * i), k * i);
                }
                data4.put("j" + (j * i), data5);
            }
            list.add(data4);

            data1.put("i" + i, list);
        }

        String jsonString = encoder.encode(data1, 4);
//        System.out.println(jsonString);

        JsonDecoder decoder = new JsonDecoder();
        Map<String, Object> mapJson = decoder.decode(jsonString);

        System.out.println(mapJson);
//        String jsonStringOfMap = encoder.encode(mapJson, 4);
//        System.out.println(jsonStringOfMap);
    }
}
