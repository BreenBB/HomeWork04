package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ComputersGeneralPage extends BasePage {

    @FindBy(xpath = "//a[@title='Компьютеры']")
    private WebElement buttonComputers;

    public ComputersGeneralPage(WebDriver driver) {
        super(driver);
    }

    //public void hoverOnPCDownList() {
     //   Actions builder = new Actions(driver);
     //   builder.moveToElement(hoverPCDownList).perform();
    //}

    public void clickComputersLink() {
        buttonComputers.click();
    }
}
