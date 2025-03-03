package com.webshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;

    UserHelper user;
    CartHelper item;

    HomePageHelper homePage;

    public UserHelper getUser() {
        return user;
    }

    public CartHelper getItem() {
        return item;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        item = new CartHelper(driver);
        homePage = new HomePageHelper(driver);

    }

    public void stop(){
        driver.quit();
    }
}
