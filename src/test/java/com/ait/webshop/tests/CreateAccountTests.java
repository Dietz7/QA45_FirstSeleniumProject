package com.ait.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @Test
    public void registerNewUserPositiveTest() {
        //click on Register link
        click(By.cssSelector("[href='/register']"));
        //enter First Name

        //better to use id - IDs are faster and more stable, and the element has a unique ID
        // OR driver.findElement(By.xpath("//*[@id='FirstName']")); good for hierarchical or complex elements searches
        type(By.cssSelector("#FirstName"), "Juli");


        type(By.cssSelector("#LastName"), "Tester");

        type(By.cssSelector("#Email"), "juli777@gmail.com");

        type(By.cssSelector("#Password"), "Qwerty1!$");

        type(By.cssSelector("#ConfirmPassword"), "Qwerty1!$");
        //click on Registration button
        click(By.cssSelector("[name='register-button']"));

        Assert.assertFalse(isElementPresent(By.cssSelector(".login-button")));
        Assert.assertTrue(isElementPresent(By.cssSelector(".account")));
    }
}
