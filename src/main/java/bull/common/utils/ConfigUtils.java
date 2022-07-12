package bull.common.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private final Properties optDataProperties;

    public ConfigUtils(String path) {
        optDataProperties = new Properties();
        try {
            InputStream is = ConfigUtils.class.getClassLoader()
                    .getResourceAsStream(path);
            optDataProperties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Load Properties of :" + path + " io error", e);
        }
    }

    public String getProperties(String key) {
        return optDataProperties.getProperty(key);
    }

    public String getProperties(String key, String defaultValue) {
        return optDataProperties.getProperty(key) == null
                ? defaultValue : optDataProperties.getProperty(key);
    }
}

