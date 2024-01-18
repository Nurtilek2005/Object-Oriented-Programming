package me.nurtilek2005.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.StringWriter;

public class JsonEncoder {

    public String encode(Object object) {
        return encode(object, 2);
    }

    public String encode(Object object, int indent) {
        Gson gson = new GsonBuilder().create();
        if (indent > 0) {
            try (StringWriter stringWriter = new StringWriter()) {
                JsonElement jsonElement = gson.toJsonTree(object);
                jsonElement.getAsJsonObject();
                try (StringWriter sw = new StringWriter();
                     JsonWriter jsonWriter = new JsonWriter(sw)) {
                    jsonWriter.setIndent(" ".repeat(indent));
                    gson.toJson(jsonElement, jsonWriter);
                    return sw.toString();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return gson.toJson(object);
    }
}
