package com.heroku.projectUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;

public class ExtentReportManager {
    private static ExtentReports extent;
    public static ExtentReports createInstance(){
        final String directory = System.getProperty("user.dir") + "/reports/";
        new File(directory).mkdirs();
        String path = directory+"TestResults.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setDocumentTitle("Automation Reports");
        sparkReporter.config().setReportName("Public API Test Results");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimelineEnabled(false);
        sparkReporter.viewConfigurer()
                .viewOrder()
                .as(new ViewName[] {
                        ViewName.DASHBOARD,
                        ViewName.CATEGORY,
                        ViewName.TEST,
                        ViewName.EXCEPTION
                })
                .apply();

        extent = new ExtentReports();
        extent.setSystemInfo("Organization","rkv");
        extent.setSystemInfo("Scope","UI Tests");
        extent.setSystemInfo("Image","maven:3.8-jdk-17-slim");
        extent.attachReporter(sparkReporter);
        return extent;
    }
}
