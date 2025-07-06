package main.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/resources/application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Failed to load application.properties: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static void set(String key, String value) {
        properties.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream("src/resources/application.properties")) {
            properties.store(fos, "Updated config");
        } catch (IOException e) {
            System.out.println("Failed to save properties.");
        }
    }



}
