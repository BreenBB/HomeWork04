package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PruductPageTests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 30;

    //In progress, switched to Final task...
    @Test
    public void checkPriceAscensionSorting() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().hoverOnComputersLink();
        getHomePage().clickOnComputersLink();
        getComputersGeneralPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getComputersGeneralPage().clickComputersLink();
    }

}
