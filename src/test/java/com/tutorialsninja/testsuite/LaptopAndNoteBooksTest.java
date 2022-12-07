package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.Desktop;
import com.tutorialsninja.pages.LaptopAndNoteBooks;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopAndNoteBooksTest extends BaseTest{

Desktop desktop = new Desktop();
LaptopAndNoteBooks laptopAndNoteBooks = new LaptopAndNoteBooks();

@Test

   public void verifyProductsPriceDisplayHighToLowSuccessfully(){

    laptopAndNoteBooks.clickOnLaptopsLink();
    laptopAndNoteBooks.clickOnAllLaptopAndNotebooksLink();
    laptopAndNoteBooks.shortPriceLowToHigh();

    }
    @Test
    public void verifyTheUserPlaceOrderSuccessfuly() throws InterruptedException{

    desktop.clickOnCurrencyLink();
    laptopAndNoteBooks.changeCurrency();
    Thread.sleep(2000);
    laptopAndNoteBooks.clickOnLaptopsLink();
    laptopAndNoteBooks.clickOnAllLaptopAndNotebooksLink();
    laptopAndNoteBooks.shortPriceLowToHigh();
    laptopAndNoteBooks.clickOnMacbookLink();


        Assert.assertEquals(laptopAndNoteBooks.getVerifyMacbook(), "MacBook", "Error Message not displayed");
laptopAndNoteBooks.clickOnAddToCart();
        Assert.assertEquals(laptopAndNoteBooks.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopAndNoteBooks.clickOnShoppingCart();
        Assert.assertEquals(laptopAndNoteBooks.getVerifyCart(), "shopping cart", "Error Message not displayed");
        Assert.assertEquals(laptopAndNoteBooks.getVerifyProductMacbook(), "MacBook", "Error Message not displayed");

        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), " ");
        laptopAndNoteBooks.clickOnUpdateCart();
        Thread.sleep(2000);
        Assert.assertEquals(laptopAndNoteBooks.getVerifyCartText(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        Assert.assertEquals(laptopAndNoteBooks.getVerifyTotal(), "2 item(s) - £737.45", "Error Message not displayed");

        laptopAndNoteBooks.clickOnCheckoutCart();
        laptopAndNoteBooks.clickOnFinalCheckout();

        Assert.assertEquals(laptopAndNoteBooks.getVerifyCheckout(), "Checkout", "Error Message not displayed");
        Assert.assertEquals(laptopAndNoteBooks.getVerifyNewCustomer(), "New Customer", "Error Message not displayed");

        laptopAndNoteBooks.clickOnGuestCheckout();
        laptopAndNoteBooks.clickOnContinueTab();
        laptopAndNoteBooks.enterName("Krish");
        laptopAndNoteBooks.enterLastName("Desai");
        laptopAndNoteBooks.enterEmail("KDesai@gmail.com");
        laptopAndNoteBooks.enterTelephone("20Tudor4060");
        laptopAndNoteBooks.enterAddress("TudorWalk");
        laptopAndNoteBooks.enterCity("Watford");
        laptopAndNoteBooks.enterPostcode("WD24 7PA");
        laptopAndNoteBooks.enterCountry("UK");
        laptopAndNoteBooks.enterState("London");

        laptopAndNoteBooks.clickOnCheckout();
        laptopAndNoteBooks.enterText("Please Update Delivery date.");

        laptopAndNoteBooks.clickOnTerms();
        laptopAndNoteBooks.clickContinue();

        Assert.assertEquals(laptopAndNoteBooks.getVerifyWarningMsg(), "Warning: Payment method required!\n" +
                "×", "Error Message not displayed");

    }

}



