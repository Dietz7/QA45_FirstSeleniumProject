package com.ait.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {

    WebDriver driver;
    // This allows multiple methods in the class to access and use the driver object.


    //before - setUp Runs before each test, initializes the WebDriver.
    @BeforeMethod
    //
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app/"); // without history
        // driver.navigate().to("https://ilcarro.web.app/"); // with history

        //driver.navigate().back();
        //driver.navigate().forward();
        // driver.navigate().refresh();
        //maximise browser to window
        driver.manage().window().maximize();


        //wait for all elements on the website to load before starting test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }


    //test - we give a name
    @Test
    public void openChromeTest() {
        System.out.println("Browser opens!");
    }

    @Test
    public void findElementsByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("h2"));
        System.out.println(element1.getText());

        WebElement element2 = driver.findElement(By.tagName("a"));
        System.out.println(element2.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementById() {
        driver.findElement(By.id("city"));
        driver.findElement(By.id("dates"));
    }

    @Test

    public void findElementByClassName() {
        WebElement element = driver.findElement(By.className("header"));
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.className("logo"));
        System.out.println(elements.size());

        WebElement element1 = driver.findElement(By.className("navigation-link"));
        System.out.println(element1.getText());

    }


    //after - tearDown
    @AfterMethod(enabled = false) //so we can see what is happening thanks to switching off the work of the method
    public void tearDown() {
        driver.quit(); //all tabs & close browser
        //driver.close(); // only current tab
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());
        System.out.println("***********************************");

        WebElement linkText1 = driver.findElement(By.linkText("Terms of use"));
        System.out.println(linkText1.getText());
        System.out.println("****************************************");

        WebElement partialLinkText = driver.findElement(By.partialLinkText("car work"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //tagName -> css
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id -> css - #
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        //className -> css - .
        //driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector(".header"));

        //[key='value']
        driver.findElement(By.cssSelector("[type='submit']"));
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='dates']"));

        //contains -> *
        driver.findElement(By.cssSelector("[href*='results?']"));

        //start with -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));

        //end on -> $
        driver.findElement(By.cssSelector("[href$='Tokyo']"));

        driver.findElement(By.cssSelector(".logo>img"));

        driver.findElement(By.cssSelector(".navigation-link:nth-child(5)"));
        driver.findElement(By.cssSelector(".title:nth-child(2)"));
        driver.findElement(By.cssSelector(".description:nth-child(1)"));
        driver.findElement(By.cssSelector(".top-cities>a:nth-child(1)"));
    }

}





