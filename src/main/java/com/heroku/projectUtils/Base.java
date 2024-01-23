package com.heroku.projectUtils;

import com.heroku.configuration.CreateBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();


    public  WebDriver  setupDriver(String browser){
        driver.set(CreateBrowser.instance(browser));
        return driver.get();
    }
}
