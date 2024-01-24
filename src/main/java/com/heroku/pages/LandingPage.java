package com.heroku.pages;

import com.google.gson.JsonObject;
import com.heroku.projectUtils.GetData;
import com.heroku.projectUtils.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    WebDriver driver;
    WebDriverWait wait;

    Integer waitTime = Integer.valueOf(GetData.fromProperties("src/main/resources/config.properties", "EXPLICIT_TIMEOUT"));

    JsonObject landingPageObj = JsonUtils.getJsonFileObj("src/main/java/com/heroku/identifiers/dashboard.json");
    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForPageToLoad(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(landingPageObj.get("contentID").toString())));
    }

    public WebElement getFormLogin(){
        return driver.findElement(By.linkText(landingPageObj.get("formAuth").toString()));
    }
}
