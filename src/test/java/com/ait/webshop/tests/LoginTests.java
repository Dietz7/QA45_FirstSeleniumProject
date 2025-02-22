package com.ait.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        //click on Register link
        click(By.cssSelector("[href='/login']"));
        //enter First Name

        //better to use id - IDs are faster and more stable, and the element has a unique ID
        // OR driver.findElement(By.xpath("//*[@id='FirstName']")); good for hierarchical or complex elements searches

        type(By.cssSelector("#Email"), "juli777@gmail.com");

        type(By.cssSelector("#Password"), "Qwerty1!$");

        //Log in
        click(By.cssSelector(".login-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector("a.ico-logout[href='/logout")));
        // Log out :)
        //click(By.cssSelector("a.ico-logout[href='/logout"));
    }
}