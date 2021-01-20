package utils;

import exceptions.CustomException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static final String PATH_TO_PROPERTIES = "src/test/resources/configs.properties";
    private static final Logger LOG = LogManager.getLogger(PropertyUtils.class);
    private static final Properties prop = getProperty();

    private static Properties getProperty() {
        Properties properties = new Properties();
        LOG.info("Reading properties from " + PATH_TO_PROPERTIES);
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new CustomException(PATH_TO_PROPERTIES + " not found", e);
        }
        return properties;
    }

    public static String getValue(String key) {
        return prop.getProperty(key);
    }
}