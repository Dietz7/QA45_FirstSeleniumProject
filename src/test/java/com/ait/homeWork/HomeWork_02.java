package com.ait.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWork_02 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/"); //without history
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void openDemoWebsiteTest() {
        System.out.println("The tested website opens!");
    }

    @Test
    public void findElementsByTagName() {
        WebElement element = driver.findElement(By.tagName("h2"));
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println("Total <a> tags found: " + elements.size());

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Total <button> tags found: " + buttons.size());

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("Total <input> tags found: " + inputs.size());

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total <img> tags found: " + images.size());

        WebElement paragraph = driver.findElement(By.tagName("p"));
        System.out.println(paragraph.getText());

        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        System.out.println("Total <p> tags found: " + paragraphs.size());
    }

    @Test
    public void findElementById() {
        driver.findElement(By.id("mob-menu-button"));
        driver.findElement(By.id("newsletter-email"));
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.id("pollanswers-1"));
    }

    @Test
    public void findElementByClassName() {
        WebElement element1 = driver.findElement(By.className("header-menu"));
        System.out.println("Header Menu: " + element1.getText());
        System.out.println("***********************************************************");

        WebElement element3 = driver.findElement(By.className("product-title"));
        System.out.println("Product Title: " + element3.getText());
        System.out.println("************************************************************");

        WebElement element4 = driver.findElement(By.className("rightside-3"));
        System.out.println(element4.getText());
        System.out.println("************************************************************");

        WebElement element2 = driver.findElement(By.className("footer"));
        System.out.println("Footer: " + element2.getText());
        System.out.println("************************************************************");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

}
