package me.nurtilek2005.homework6.srp2.provider;

import me.nurtilek2005.homework6.srp2.Order;
import me.nurtilek2005.homework6.srp2.OrderList;

import java.io.FileWriter;
import java.io.IOException;

public class CsvProvider implements IProvider {
    FileWriter writer;

    public CsvProvider() {
        try {
            writer = new FileWriter("data.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public void save(OrderList orderList) {

    }

    @Override
    public void save(Order orderList) {

    }
}
