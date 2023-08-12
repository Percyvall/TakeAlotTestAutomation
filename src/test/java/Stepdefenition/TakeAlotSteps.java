package Stepdefenition;

import Accelerators.ActionsClass;
import Accelerators.Base;
import PageObjects.TakeAlotObjects;
import Utility.utils;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TakeAlotSteps {
    static WebDriver newdriver = Base.driver;
    static WebDriver driver1;
    public static String sNewWindow = "";
    public static String uniqueName = "";

    @Before
    public void setUp() throws Exception {
        try {
            ActionsClass.sTestCaseName = this.toString();
            ActionsClass.sTestCaseName = utils.getTestCaseName(ActionsClass.sTestCaseName);
        } catch (Exception e) {

        }
    }

    @Given("^user is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
        try {
            Base.sBrowserName = utils.getProperty("browserName");
            System.out.println("BrowserType =" + Base.sBrowserName);
            newdriver = Base.OpenBrowser(Base.sBrowserName);
            newdriver = Base.driver;
        } catch (Exception e) {
        }


    }

    @Then("^user types in the Search bar$")
    public void user_types_in_the_Search_bar() throws Throwable {
        try {
            ActionsClass.typeInTextBox(TakeAlotObjects.TypeInSearch, "Kenwood - 8L kHealthy Dual Air Fryer - HFP70.000BK", "typingProductName");
            ActionsClass.clickOnElement(TakeAlotObjects.Search,"Search");
        } catch (Exception e) {

        }
    }

    @Then("^user adds first item to cart$")
    public void user_selects_first_air_fryer() throws Throwable {
        try {
            ActionsClass.clickOnElement(TakeAlotObjects.SelectFirstItem, "Select First Item");
        } catch (Exception e) {

        }

    }

    @Then("^user clicks on cart button$")
    public void user_clicks_add_to_cart_button() throws Throwable {
        try {
            ActionsClass.clickOnElement(TakeAlotObjects.GoToCart, "Go to cart");
        } catch (Exception e) {

        }

    }

    @Then("^user goes to cart$")
    public void user_goes_to_cart() throws Throwable {
        try {
            String CartItem;
            CartItem = ActionsClass.getObjectText(TakeAlotObjects.CartItem, "CartItem");
            Assert.assertEquals("Cart Item added", "Kenwood - 8L kHealthy Dual Air Fryer - HFP70.000BK", CartItem);
        } catch (Exception e) {

        }

    }

}

