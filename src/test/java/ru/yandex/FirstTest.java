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
import ru.yandex.TestListener;

@Listeners(TestListener.class)
public class FirstTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunth\\Downloads\\chromedriver-win64\\chromedriver.exe");
    }

    public WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }

    @Test
    public void googleSearchTest() {
        getDriver().get("https://www.google.com");
        getDriver().manage().window().maximize();
        By searchBox = By.name("q");
        getDriver().findElement(searchBox).click();
        getDriver().findElement(searchBox).sendKeys("yandex");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        By searchButton = By.name("btnK");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    @Test
    public void yandexSearchTest() {
        getDriver().get("https://www.yandex.ru");//этот тест с ошибкой для скриншота(у яндекса домен ya.ru сейчас)
        getDriver().manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        By searchBox = By.cssSelector("input[name='text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys("yandex");
        By searchButton = By.cssSelector("button[type='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }


    @AfterClass
    public void tearDown() {
        if (driver.get() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
// todo сделать 2 теста параллельных один в гугле другой в яндексе
// todo сделать специально тест с ошибкой, чтобы снимал скрин
// todo поизучать гит