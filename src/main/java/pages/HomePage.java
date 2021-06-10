package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='q']")
    WebElement searchField;

    @FindBy(xpath = "//span[@id='find']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@id='tab-1']")
    WebElement computerTechButton;

    @FindBy(xpath = "//div[@id='tabmenu-1']")
    WebElement computerTechPopup;

    @FindBy(xpath = "//a[@href='/desktops/'and @class='tb-a']")
    WebElement pcsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchInput() {
        return searchField;
    }

    public void enterTextToSearchField(String input) {
        searchField.clear();
        searchField.sendKeys(input);
    }

    public void moveToComputerTechButton()  {
        Actions builder = new Actions(driver);
        builder.moveToElement(computerTechButton).perform();
    }

    public WebElement getComputerTechPopup() {
        return computerTechPopup;
    }

    public void clickOnPCsButton() {
        pcsButton.click();
    }
    public void clickOnSearchButton() {
        searchButton.click();
    }

}
