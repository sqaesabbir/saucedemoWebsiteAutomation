package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;
    static {
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream("src/config.properties");
            properties.load(input);
            System.out.println("Config loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
