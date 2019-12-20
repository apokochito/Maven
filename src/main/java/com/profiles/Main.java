package com.profiles;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String args[]){

        Main app = new Main();
        Properties properties = app.loadPropertiesFile("db.properties");
    }

    public Properties loadPropertiesFile(String filePath){
        Properties properties = new Properties();
        try(InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)){

        }catch (IOException e){
            System.out.println("Unable to load properties file: "+filePath);
        }
        return properties;
    }
}
