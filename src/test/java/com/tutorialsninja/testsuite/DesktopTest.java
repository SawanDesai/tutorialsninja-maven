package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.Desktop;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNoteBooks;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopTest extends BaseTest {

    HomePage homePage = new HomePage();
    Desktop desktop = new Desktop();
 LaptopAndNoteBooks laptopAndNoteBooks = new LaptopAndNoteBooks();
    //****************************************DesktopTest******************************************************

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        homePage.clickOnDesktopLink();
        desktop.clickOnAllDesktop();
        desktop.verifyZtoAFromDropDroDown();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully () throws InterruptedException {
        desktop.clickOnCurrencyLink();
        laptopAndNoteBooks.changeCurrency();
        homePage.clickOnDesktopLink();
        desktop.clickOnAllDesktop();
        desktop.SortByNameZtoAFromDropdown();
        desktop.clickOnHPlp3065();
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(desktop.getVerifyTextHp(), expectedMessage, "Error Message not displayed");
        desktop.selectDeliveryDate();
        //desktops.changeQuantity("1");
        desktop.clickOnAdToCart();
        String expectedMessage1 = "Success: You have added HP LP3065 to your shopping cart!";
        Assert.assertEquals(desktop.getVerifyShoppingCart(), expectedMessage, "Error Message not displayed");
        desktop.clickOnShoppingCart();
        Thread.sleep(3000);
        //Assert.assertEquals(desktops.getVerifyShoppingCart(), "Shopping Cart", "Error Message not displayed");
        Assert.assertEquals(desktop.getVerifyProductName(), "HP LP3065", "Error Message not displayed");
        //  String expectedMessage4 = "2022-11-30";
        // Assert.assertEquals(desktops.getVerifyDeliveryDate(), expectedMessage, "Error Message not displayed");
        Assert.assertEquals(desktop.getVerifyModel(), "Product Code: Product 21", "Error Message not displayed");
        Thread.sleep(2000);
        //Assert.assertEquals(desktops.getVerifyTotal(), "£74.73", "Error Message not displayed");

    }
}
