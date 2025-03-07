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

    @Test
    public void findElementByCssSelector() {

        //tagName -> css
        //driver.findElement(By.tagName("h2"));
        driver.findElement(By.cssSelector("h2"));
        //id -> css - #
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#mob-menu-button"));

        //className -> css - .
        //driver.findElement(By.className("header-menu"));
        driver.findElement(By.cssSelector(".header-menu"));

        //[key='value']
        driver.findElement(By.cssSelector("[name='NewsletterEmail']"));

        //contains -> * Checks if the href attribute contains the substring 'producttag' anywhere in its value.
        driver.findElement(By.cssSelector("[href*='producttag']"));

        //start with -> ^
        driver.findElement(By.cssSelector("[id^='small-']"));

        //end on -> $
        driver.findElement(By.cssSelector("[href$='electronics']"));

        // > direct child combintator
        // selects an <img> tag that is a direct child of .nivo-imageLink
        driver.findElement(By.cssSelector(".nivo-imageLink>img"));

        //selects the second child among its siblings within the class top-menu-triangle
        driver.findElement(By.cssSelector(".top-menu-triangle:nth-child(2)"));
        // or the same as above but using > and nth-child together
        driver.findElement(By.cssSelector(".top-menu>li:nth-child(3)"));

    }

    @Test
    public void findElementByXpath() {
        // xpath -> //*[@key='value']
        //driver.findElement(By.tagName("h2"));
        driver.findElement(By.xpath("//h2"));

        //driver.findElement(By.id("pollaranswers-1"));
        driver.findElement(By.id("pollanswers-1"));
        // or please see the line below
        driver.findElement(By.xpath("//input[@id='pollanswers-1']"));

        driver.findElement(By.xpath("//*[@class='header-menu']"));

        driver.findElement(By.xpath("//*[@type='submit']"));

        driver.findElement(By.xpath("//*[@href='/producttag/4/apparel']"));

        driver.findElement(By.xpath("//*[contains(.,'Jewel')]"));

        driver.findElement(By.xpath("//*[text()='Categories']"));
        // or
        driver.findElement(By.xpath("//*[.='Categories']"));

        //parent  The /.. means "go to the parent of this element." In our case the parent is div of the h2
        driver.findElement(By.xpath("//h2/.."));
        // /.. and /parent::* do the same thing: find the parent of the <h2>.
        driver.findElement(By.xpath("//h2/parent::*"));
        ///parent::div is more specific and only finds the parent if it's a <div>
        driver.findElement(By.xpath("//h2/parent::div"));

        // finds the first (closest) ancestor that is wrapping h2, regardless of the tag name.
        driver.findElement(By.xpath("//h2/ancestor::*"));
        //finds the nearest wrapping <div>
        driver.findElement(By.xpath("//h2/ancestor::div"));
        //this goes up the ancestor tree and picks the second <div> found, the second ancestor <div> is the outer one
        driver.findElement(By.xpath("//h2/ancestor::div[2]"));

    }
}
