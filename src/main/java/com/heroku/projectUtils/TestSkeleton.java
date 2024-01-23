package com.heroku.projectUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public interface TestSkeleton {

    @BeforeMethod
    void setup();

    @AfterMethod
    void tearDown();
}
