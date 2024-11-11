package test;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class YandexTest extends BaseTest {

    @Test
    public void yandexSearchTest() throws InterruptedException {
        driver.get("https://www.ya.ru");
        page.inputSecondPage();

    }
}