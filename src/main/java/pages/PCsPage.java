package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
;import java.util.List;

import static org.openqa.selenium.By.xpath;

public class PCsPage extends BasePage {

    @FindBy(xpath = "//input[@name='minPrice']")
    WebElement inputMinPrice;

    @FindBy(xpath = "//input[@name='maxPrice']")
    WebElement inputMaxPrice;

    @FindBy(xpath = "//div[@class='price-input']/button[@name='gofilter']")
    WebElement buttonPriceConfirm;

    @FindBy(xpath = "//a[@class='vit-name']")
    List<WebElement> productList;

    @FindBy(xpath = "//span[@class='current']//span[contains(text(),'по релевантности')]")
    WebElement sortingDropDownMenu;

    @FindBy(xpath = "//a[contains(text(),'от дешевых')]")
    WebElement sortingSelectAscending;

    @FindBy(xpath = "//a[contains(text(),'от дорогих')]")
    WebElement sortingSelectDescending;

    @FindBy(xpath = "//span[@class='price vit-cost']")
    List<WebElement> productPriceList;

    public List<WebElement> getProductPriceList() {
        return productPriceList;
    }

    public WebElement getSortingDropDownMenu() {
        return sortingDropDownMenu;
    }

    public WebElement getSortingSelectAscending() {
        return sortingSelectAscending;
    }

    public WebElement getSortingSelectDescending() {
        return sortingSelectDescending;
    }

    public void clickOnSortingDropDownMenu() {
        sortingDropDownMenu.click();
    }

    public void clickOnSortingSelectAscending() {
        sortingSelectAscending.click();
    }

    public void clickOnSortingSelectDescending() {
        sortingSelectDescending.click();
    }

    public double getProductPrice(int i) {
        List<WebElement> actualProductPrice = productPriceList.get(i).findElements(By.xpath("*"));

        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < actualProductPrice.size(); j++) {
            if (actualProductPrice.get(j).isDisplayed())
                builder.append(actualProductPrice.get(j).getText());
        }

        String result = builder.toString();
        return Double.parseDouble(result.replaceAll("[^0-9.]", ""));
    }

    public void enterInputMinPriceField(String input) {
        inputMinPrice.clear();
        inputMinPrice.sendKeys(input);
    }

    public void enterInputMaxPriceField(String input) {
        inputMaxPrice.clear();
        inputMaxPrice.sendKeys(input);
    }

    public void clickOnButtonPriceConfirm() {
        buttonPriceConfirm.click();
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public PCsPage(WebDriver driver) {
        super(driver);
    }
}
