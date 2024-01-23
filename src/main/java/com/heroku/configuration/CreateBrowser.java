package com.heroku.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class CreateBrowser {
    private  static  WebDriver driver;
    public  static  String url="https://the-internet.herokuapp.com/";

    public static WebDriver instance (String browser){

        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions cops = new ChromeOptions();
            cops.addArguments("--headless=new");
            driver = new ChromeDriver(cops);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions fops = new FirefoxOptions();
            fops.addArguments("--headless");
            driver = new FirefoxDriver(fops);
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }
}
