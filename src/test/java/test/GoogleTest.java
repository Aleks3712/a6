package test;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class GoogleTest extends BaseTest {

    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.get("https://www.google.com");
        page.inputFirstPage();

    }
}
