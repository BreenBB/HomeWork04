package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 30;
    private static final String TEXT_TO_SEARCH = "iPhone 11";
    private static final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "1";
    private static final String EXPECTED_EMPTY_CART_NOTIFICATION_TEXT = "Ваша корзина пуста";

    @Test
    public void checkSearchResult() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().enterTextToSearchField(TEXT_TO_SEARCH);
        getHomePage().clickOnSearchButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        Assert.assertTrue(getSearchPage().getResultName().get(0).isDisplayed());
        int count = getSearchPage().getResultName().size();
        boolean correctResult=true;
        for (int i = 0; i < count; i++) {
            if (!getSearchPage().getResultName().get(i).getText().contains(TEXT_TO_SEARCH)) {
                correctResult=false;
                break;
            }
        }
        Assert.assertTrue(correctResult);
    }

    @Test
    public void checkRemoveFromCart() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().enterTextToSearchField(TEXT_TO_SEARCH);
        getHomePage().clickOnSearchButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        Assert.assertTrue(getSearchPage().getResultName().get(0).isDisplayed());
        getSearchPage().clickOnFirstSearchResultItem();
        getIPhone11Page().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getIPhone11Page().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getIPhone11Page().clickOnAddToCartButton();
        getIPhone11Page().clickOnGoToHomePageButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        Assert.assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
        getHomePage().clickOnCartButton();
        getCartPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getCartPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getCartPage().clickOnRemoveFromCartButton();
        getCartPage().clickOnCartButton();
        Assert.assertEquals(getCartPage().getTextOfEmptyCartNotification(), EXPECTED_EMPTY_CART_NOTIFICATION_TEXT);
    }



}
