package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IPhone11Page extends BasePage {

    @FindBy(xpath = "//div[@class='no-print ready btn']")
    WebElement addToCartButton;

    public IPhone11Page(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }
}
