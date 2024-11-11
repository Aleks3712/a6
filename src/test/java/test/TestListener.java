package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    private WebDriver getDriver(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) {
            return ((BaseTest) testInstance).driver;
        }
        return null;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseTest.driver;

        if (driver != null) {  // Скриншот для UI-тестов с WebDriver
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(screenshot, new File("C:\\Users\\sunth\\Downloads/" + result.getName() + ".png"));
                System.out.println("Скриншот сохранен: " + "C:\\Users\\sunth\\Downloads/" + result.getName() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {  // Скриншот экрана для API-тестов
            try {
                Robot robot = new Robot();
                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage screenCapture = robot.createScreenCapture(screenRect);

                File screenFile = new File("C:\\Users\\sunth\\Downloads/" + result.getName() + "_fullScreen.png");
                ImageIO.write(screenCapture, "png", screenFile);
                System.out.println("Скриншот экрана сохранен: " + screenFile.getPath());
            } catch (AWTException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Остальные методы можно оставить пустыми
    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onTestFailedWithTimeout(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}
