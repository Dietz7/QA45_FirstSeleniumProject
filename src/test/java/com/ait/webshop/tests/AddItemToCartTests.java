package com.ait.webshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddItemToCartTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        //click on Log in link
        click(By.cssSelector("[href='/login']"));

        type(By.cssSelector("#Email"), "juli777@gmail.com");

        type(By.cssSelector("#Password"), "Qwerty1!$");

        //Log in
        click(By.cssSelector(".login-button"));

        //select the second product on the page and add to the cart
        click(By.xpath("//input[contains(@onclick, '/catalog/31/')]"));

        click(By.cssSelector("a.ico-cart"));
        Assert.assertTrue(isItemAddedByText("14.1-inch Laptop"));

        //Assert.assertTrue(isElementPresent(By.xpath("//td[@class='product']/a[contains(text(), '14.1-inch Laptop')]")),
              //  "Product was not found in the cart");

    }

    @AfterMethod
    public void postCondition(){

        click(By.xpath("//tr[td[@class='product']]//input[@name='removefromcart']"));

        click(By.cssSelector("input[name='updatecart']"));
    }
   public boolean isItemAddedByText(String text){
       List<WebElement> items = driver.findElements(By.cssSelector("td.product a"));
       for (WebElement element: items){
           if(element.getText().contains(text)) return true;
       }
       return false;
   }

}