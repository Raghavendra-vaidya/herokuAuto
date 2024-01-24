package com.heroku.projectUtils;

import org.apache.poi.ss.usermodel.*;

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

    public static String fromExcel(String filePath, String sheetName, int rIndex, int cIndex){
        String data = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook wb = WorkbookFactory.create(fileInputStream);
            Sheet st = wb.getSheet(sheetName);
            Row r = st.getRow(rIndex);
            Cell cell = r.getCell(cIndex);
            data = new DataFormatter().formatCellValue(cell);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
