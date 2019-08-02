package com.itdr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesGetUtil {
    public  static  String getvalus (String key){
        Properties ps = new Properties();
        InputStream in = PropertiesGetUtil.
                class.getClassLoader().getResourceAsStream("const.properties");
        try {
            ps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String valus = ps.getProperty(key);

        return valus;
    }

    public static void main(String[] args) {
        System.out.println(getvalus("USER_DISABLE_CODE"));
        System.out.println(getvalus("USER_DISABLE_MSG"));
    }
}
