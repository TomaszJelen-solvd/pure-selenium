package com.solvd.util;

import com.solvd.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream inStream = Main.class.getResourceAsStream("/application.properties")) {
            properties.load(inStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application properties");
        }
        return properties;
    }
}
