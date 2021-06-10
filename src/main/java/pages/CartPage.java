package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//a[@id='delete_1170439']")
    WebElement removeFromCartButton;

    @FindBy(xpath = "//td[contains(text(),'Ваша корзина пуста')]")
    WebElement emptyCartNotification;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRemoveFromCartButton() {
        removeFromCartButton.click();
    }

    public String getTextOfEmptyCartNotification() {
        return emptyCartNotification.getText();
    }


}
