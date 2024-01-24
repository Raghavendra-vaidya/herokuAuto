package com.heroku.pages;

import com.google.gson.JsonObject;
import com.heroku.projectUtils.Base;
import com.heroku.projectUtils.GetData;
import com.heroku.projectUtils.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class LoginPage  {

    WebDriver driver;
    WebDriverWait wait;

    Integer waitTime = Integer.valueOf(GetData.fromProperties("src/main/resources/config.properties", "EXPLICIT_TIMEOUT"));

    JsonObject jsonObject = JsonUtils.getJsonFileObj("src/main/java/com/heroku/identifiers/loginPage.json");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForPageToLoad(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(jsonObject.get("allContentID").toString())));
    }

    public WebElement getUserNameField(){
        return driver.findElement(By.id(jsonObject.get("usernameID").toString()));
    }

    public WebElement getPasswordField(){
        return driver.findElement(By.id(jsonObject.get("passwordID").toString()));
    }

    public WebElement getLoginBtn(){
        return driver.findElement(By.xpath(jsonObject.get("loginBtn").toString()));
    }

}
