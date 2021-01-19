package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigurationReader {

    public static final String PAGELOAD = "pageload";
    public static final String WEBDRIVERWAIT = "webdriverwait";

    /**
     * method for reading properties from file in resource
     *
     * @param filename filename
     * @return Properties object
     */
    private static Properties readPropertiesFile(String filename) {
        Properties properties = null;
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * method for creating map for load times
     *
     * @return Map with key as String, and value as String
     */
    private Map<String, String> getLoadTime() {
        Properties properties = readPropertiesFile("src/main/resources/loadTime.properties");
        Map<String, String> map = new HashMap<>();
        map.put(PAGELOAD, properties.getProperty(PAGELOAD));
        map.put(WEBDRIVERWAIT, properties.getProperty(WEBDRIVERWAIT));
        return map;
    }

    /**
     * gets Long with seconds for page load time
     *
     * @return Long with seconds
     */
    public Long getPageloadTime() {
        return Long.parseLong(getLoadTime().get(PAGELOAD));
    }

    /**
     * gets Long with seconds used in WebDriverWait
     *
     * @return Long with seconds
     */
    public Long getWebdriverwaitTime() {
        return Long.parseLong(getLoadTime().get(WEBDRIVERWAIT));
    }
}

