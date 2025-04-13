package org.ecm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigUtils : Utility used to load the properties files
 *
 * @author Abhishek Arora
 * @since  26-03-2025
 *
 */
public class ConfigUtils {

    static Properties prop = new Properties();

    public static void loadProperties() {
        try {
            prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/config.properties")));
            System.out.println(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        return prop.getProperty(key);
    }
}
