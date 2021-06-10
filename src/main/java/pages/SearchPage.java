package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//section[@class='vit-info']/a[@class='vit-name']")
    List<WebElement> resultName;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getResultName() {
        return resultName;
    }

    public void clickOnFirstSearchResultItem() {
        resultName.get(0).click();
    }
}
