package com.haifeng.crypto.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class StringUtils {
    private static final String PATH = "input/input.properties";
    private static Properties properties = new Properties();
    public static void read(){
        URL url = StringUtils.class.getClassLoader().getResource(PATH);
        try(InputStream is = new FileInputStream(url.getPath())){
            properties.load(is);
        }catch (IOException e){

        }
    }
}
