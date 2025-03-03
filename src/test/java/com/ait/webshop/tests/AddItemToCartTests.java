package com.ait.webshop.tests;

import com.webshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

   // @BeforeMethod
    //public void ensurePrecondition() {
       // if(!app.getUser().isAccountPresent(){
          //  app.getUser().
        //}

    //}

    @Test
    public void addItemPositiveTest() {
       // app.getUser().confirmLogin(); // precondition connected with this action because we are loggedin
        //select the second product on the page and add to the cart
        app.getItem().addSelectedItemToCart();

        app.getItem().navigateToShoppingCart();
        Assert.assertTrue(app.getItem().isItemAddedByText("14.1-inch Laptop"));

        //Assert.assertTrue(isElementPresent(By.xpath("//td[@class='product']/a[contains(text(), '14.1-inch Laptop')]")),
        //  "Product was not found in the cart");

    }

    @AfterMethod
    public void postCondition() {

        app.getItem().removeItem();

    }


}