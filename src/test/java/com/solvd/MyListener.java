package com.solvd;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Object currentClass = result.getInstance();
        WebDriver webdriver = ((AbstractTest) currentClass).getDriver();
        TakesScreenshot screenshot = ((TakesScreenshot) webdriver);
        File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(SrcFile, new File("screenshot" + testName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
