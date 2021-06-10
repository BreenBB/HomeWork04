package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSortingTests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 30;
    private static final double MINIMUM_PRICE_RANGE = 5000;
    private static final double MAXIMUM_PRICE_RANGE = 11000;

    //Здесь как и на Ebay сортировка по ценам неккоретно работает.
    //Часть товара оказывается дороже чем следующий товар, хотя сортировка идет от дешевых к дорогим
    @Test
    public void checkNegativePriceSortingInAscendingOrderHasSortingBug() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().moveToComputerTechButton();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getComputerTechPopup());
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().clickOnPCsButton();
        getPCsPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getPCsPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getPCsPage().clickOnSortingDropDownMenu();
        getPCsPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getPCsPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getPCsPage().getSortingSelectAscending());
        getPCsPage().clickOnSortingSelectAscending();
        getPCsPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getPCsPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        boolean priceSortedInAscendingOrder=true;
        for (int i = 1; i < getPCsPage().getProductPriceList().size(); i++) {
            if (getPCsPage().getProductPrice(i-1)>getPCsPage().getProductPrice(i)) {
                priceSortedInAscendingOrder=false;
                break;
            }
        }
        Assert.assertFalse(priceSortedInAscendingOrder);
    }
    @Test
    public void checkPriceRangeFiltering() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().moveToComputerTechButton();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getComputerTechPopup());
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().clickOnPCsButton();
        getPCsPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getPCsPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getPCsPage().enterInputMinPriceField(String.valueOf(MINIMUM_PRICE_RANGE));
        getPCsPage().enterInputMaxPriceField(String.valueOf(MAXIMUM_PRICE_RANGE));
        getPCsPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getPCsPage().clickOnButtonPriceConfirm();
        getPCsPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getPCsPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        boolean priceIsWithinRange=true;
        for (int i = 0; i < getPCsPage().getProductPriceList().size(); i++) {
            if (getPCsPage().getProductPrice(i)<MINIMUM_PRICE_RANGE||getPCsPage().getProductPrice(i)>MAXIMUM_PRICE_RANGE) {
                priceIsWithinRange=false;
                break;
            }
        }
        Assert.assertTrue(priceIsWithinRange);
    }
}
