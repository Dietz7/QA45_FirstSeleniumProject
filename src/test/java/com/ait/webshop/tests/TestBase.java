package com.ait.webshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isWelcomeComponentPresent() {
        //return driver.findElements(By.xpath("//h2")).size() > 0;
        return isElementPresent(By.xpath("//h2"));
    }

    //universal method for using an abstract locator, not the specific as above
    public boolean isElementPresent(By locator){
        try {
            return driver.findElements(locator).size()>0;
        } catch (Exception e) {
            return false;
        }
    }


    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
