package utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class LocalProperties {

    private final static String PROPERTY_FILE ="src/test/resources/configs/project.properties";
    private static final Logger LOG = LoggerFactory.getLogger(LocalProperties.class);
    private static Properties properties = new Properties();

    public static void propertiesFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTY_FILE)) {
            properties.load(fileInputStream);
            LOG.debug("System properties were successfully loaded, file: {}", PROPERTY_FILE);
        } catch (IOException e) {
            LOG.error("error loading properties from file {}", PROPERTY_FILE, e);
            throw new RuntimeException(e);
        }
        afterPropertiesSet();
    }

    private static void afterPropertiesSet() {
        for (Map.Entry<Object, Object> props : properties.entrySet()) {
            String key = String.valueOf(props.getKey());
            String value = String.valueOf(props.getValue());
            if (StringUtils.isBlank(System.getProperty(key))) {
                System.setProperty(key, value);
                LOG.debug("System property {} was successfully added: {}", key, value);
            }
        }
    }
}
