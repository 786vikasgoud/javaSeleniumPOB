package org.example;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    Properties properties;
    public ConfigReader() {
        loadProperties();
    }

    public void loadProperties() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("Config.Properties")) {

            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("config.properties file not found in the classpath.");
            }
        } catch (Exception e) {
            throw new RuntimeException("config.properties file not found in the classpath.");
        }
    }


    public String chromePath(){
        return properties.getProperty("chromedriver.path");
    }
    public String webUrl(){
        return properties.getProperty("amazon");
    }
    public String user(){
        return properties.getProperty("user");
    }
    public String password(){
        return properties.getProperty("password");
    }
    public String productName(){
        return properties.getProperty("productName");
    }


    @Test
    public void printalldetails(){
        System.out.println(webUrl());
        System.out.println(password());
        System.out.println(user());
        System.out.println(chromePath());
    }
}
