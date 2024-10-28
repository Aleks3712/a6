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
public class GoogleTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunth\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com");
        By searchBox = By.name("q");
        driver.findElement(searchBox).click();
        driver.findElement(searchBox).sendKeys("yandex");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By searchButton = By.name("btnK");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
