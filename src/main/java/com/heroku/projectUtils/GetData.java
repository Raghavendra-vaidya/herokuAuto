package com.heroku.projectUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GetData {

    public static String fromProperties(String filePath , String KEY){
        String data = null;
        try{
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fis);
            data = prop.getProperty(KEY);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
