package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
    public WebDriver driver;
    public FirstPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;}

//список локаторов
    @FindBy(xpath = "//textarea[@title='Поиск']")
    private WebElement papa;

    @FindBy(id = "text")
    private WebElement mama;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement deda;

    public void inputFirstPage() throws InterruptedException
    {
        papa.click();
        Thread.sleep(1000);
        papa.sendKeys("yandex");

    }

    public void inputSecondPage() throws InterruptedException{
        mama.click();
        Thread.sleep(1000);
        mama.sendKeys("yandex");
        Thread.sleep(1000);
        deda.click();
    }

}
