package com.heroku.projectUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonUtils {


    public static  JsonObject getJsonFileObj(String filePath){
        JsonObject jsonObject = null;
        try{
            Path path = Paths.get(filePath);
            Reader reader = Files.newBufferedReader(path);
            JsonElement jsonElement = JsonParser.parseReader(reader);
            jsonObject = jsonElement.getAsJsonObject();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}
