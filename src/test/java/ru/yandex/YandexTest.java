package ru.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class YandexTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunth\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void yandexSearchTest() {
        driver.get("https://www.ya.ru");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By searchBox = By.cssSelector("input[name='text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys("yandex");
        By searchButton = By.cssSelector("button[type='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}