package me.nurtilek2005.homework6.srp2.provider;

import me.nurtilek2005.homework6.srp2.Order;
import me.nurtilek2005.homework6.srp2.OrderList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import me.nurtilek2005.json.Json;

public class JsonProvider implements IProvider {
    FileWriter writer;
    FileReader reader;

    public JsonProvider() {
        try {
            writer = new FileWriter("data.json");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String read() {
        StringBuilder result = new StringBuilder();
        try {
            reader = new FileReader("data.json");
            int i;
            while ((i = reader.read()) != -1)
                result.append((char) i);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    @Override
    public void save(OrderList orderList) {
        Map<String, Object> data = new LinkedHashMap<>();
        for (Order order : orderList) {
            data.put(String.valueOf(order.getId()), order.toJson());
        }
        try {
            writer = new FileWriter("data.json");
            this.writer.write(new Json(data).toString());
            this.writer.flush();
            this.writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Order order) {
        try {
            writer = new FileWriter("data.json");
            this.writer.write(order.toJson().toString());
            this.writer.flush();
            this.writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
