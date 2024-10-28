package ru.yandex;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((WebDriverManager) currentClass).getDriver();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("C:\\Users\\sunth\\Downloads/" + result.getName() + ".png"));
            System.out.println("Скриншот сохранен: " + "C:\\Users\\sunth\\Downloads/" + result.getName() + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Остальные методы ITestListener можно оставить пустыми
    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}