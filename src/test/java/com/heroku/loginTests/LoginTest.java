package com.heroku.loginTests;

import com.heroku.projectUtils.Base;
import com.heroku.projectUtils.TestSkeleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base implements TestSkeleton {
    WebDriver driver;

    @BeforeMethod
    @Override
    public void setup() {
        driver = setupDriver("chrome");
    }


    @Test
    public void loginTest1() {
        driver.findElement(By.linkText("Basic Auth")).click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(true);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.quit();
    }
}
