package com.fileserver.Server.Config;

import java.io.FileNotFoundException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
    
    public static void writeJson(Object object, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(object);

        try {
            java.io.FileWriter writer = new java.io.FileWriter(filePath);
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readJson(String filePath, Class<Properties> clazz) {
        Gson gson = new Gson();
        Object object = null;

        try {
            java.io.FileReader reader = new java.io.FileReader(filePath);
            object = gson.fromJson(reader, clazz);
        } catch (FileNotFoundException e) {
            Properties defaultProperties = new Properties(8888, "testFSDir", new User("admin", "admin"));
            writeJson(defaultProperties, "config.json");
            object = defaultProperties;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }
}
