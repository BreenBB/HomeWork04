package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductCatalogPage extends BasePage {

    @FindBy(xpath = "//input[@name='min']")
    private WebElement priceRangeMinInput;

    @FindBy(xpath = "//input[@name='max']")
    private WebElement priceRangeMaxInput;

    @FindBy(xpath = "//select[@name='sort']")
    private WebElement sortMenu;

    @FindBy(xpath = "//option[@value='price-asc']")
    private WebElement sortAscSelection;

    @FindBy(xpath = "//option[@value='price-desc']")
    private WebElement sortDescSelection;

    @FindBy(xpath = "//div[@id='goods-list']//span[@class='product-tile_price-main']/span[@class='product-tile_price-value']")
    private List<WebElement> productPriceList;

    @FindBy(xpath = "//button[@class='js-filter-apply btn-filter-apply disabled filter-apply']")
    private WebElement buttonConfirmPress;

    public ProductCatalogPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductPriceList() {
        return productPriceList;
    }
    public double getProductPrice(int i) {
        String price = productPriceList.get(i).getText();
        return Double.parseDouble(price.replaceAll("[^0-9.]", ""));
    }

    public void clearMinimumPriceValue() {
        priceRangeMinInput.sendKeys(Keys.CONTROL + "a");
        priceRangeMinInput.sendKeys(Keys.DELETE);
    }
    public void clearMaximumPriceValue() {
        priceRangeMaxInput.sendKeys(Keys.CONTROL + "a");
        priceRangeMaxInput.sendKeys(Keys.DELETE);
    }

    public void enterMinimumPriceValue(String min) throws InterruptedException {
        Actions builder = new Actions(driver);
        builder.moveToElement(priceRangeMaxInput).perform();
        Thread.sleep(1500);
        priceRangeMaxInput.sendKeys(Keys.CONTROL + "a", "max", Keys.ENTER);
    }
    public void enterMaximumPriceValue(String max) throws InterruptedException {
        Actions builder = new Actions(driver);
        builder.moveToElement(priceRangeMaxInput).perform();
        Thread.sleep(1500);
        priceRangeMinInput.sendKeys(Keys.CONTROL + "a", "max", Keys.ENTER);
    }

    public void clickOnButtonConfirmPress() {
        waitVisibilityOfElement(30,buttonConfirmPress);
        buttonConfirmPress.sendKeys(Keys.ENTER);
    }

    public void clickOnSortMenu() {
        sortMenu.click();
    }

    public WebElement getSortAscSelection() {
        return sortAscSelection;
    }

    public void clickOnSortAscSelection() {
        waitVisibilityOfElement(30,sortAscSelection);
        sortAscSelection.click();
    }

}
