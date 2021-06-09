package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//aside[@class='sidebar sidebar_type_main']//a[@href='https://rozetka.com.ua/computers-notebooks/c80253/']")
    private WebElement computersAndNotebooksLink;

    //input[@name='search']

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hoverOnComputersLink() {
        Actions builder = new Actions(driver);
        builder.moveToElement(computersAndNotebooksLink).perform();
    }

    public void clickOnComputersLink() {
        computersAndNotebooksLink.click();
    }

}
