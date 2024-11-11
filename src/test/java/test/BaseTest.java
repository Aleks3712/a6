package test;

import pages.FirstPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.nio.file.Paths;

public class BaseTest {
    protected static WebDriver driver;
    static FirstPage page;


    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", Paths.get("chromedriver.exe").toAbsolutePath().toString());
        driver = new ChromeDriver();
        page = new FirstPage(driver);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

