package com.ait.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void login() {
        click(By.cssSelector("[href='/login']"));

        type(By.cssSelector("#Email"), "juli777@gmail.com");

        type(By.cssSelector("#Password"), "Qwerty1!$");
    }

    @Test
    public void loginPositiveTest() {
        //Log in
        click(By.cssSelector(".login-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector("a.ico-logout[href='/logout")));
        // Log out :)
        //click(By.cssSelector("a.ico-logout[href='/logout"));
    }
}