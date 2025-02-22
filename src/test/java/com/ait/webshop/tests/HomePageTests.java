package com.ait.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void isWelcomeComponentPresentTest() {
        //System.out.println("WelcomeComponent " +isWelcomeComponentPresent());
        // driver.findElement(By.xpath("//h2")); we do not need this line because we call the method
        //isWelcomeComponentPresent();
        Assert.assertTrue(isWelcomeComponentPresent());
    }
}
