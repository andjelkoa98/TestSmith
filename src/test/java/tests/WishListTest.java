package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.WishListPage;

public class WishListTest extends BaseTest{


    LoginPage loginPage;
    RegisterPage registerPage;
    WishListPage wishListPage;
    @BeforeMethod
    public void localSetup(){
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        wishListPage = new WishListPage(driver);
    }

    @Test
    public void addProductToWishList() throws InterruptedException {
        registerPage.goToRegisterPage()
                .registerUser();
        Thread.sleep(2000);
        loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());

        softAssert.assertTrue(registerPage.isUserRegistered());

        wishListPage.addProduct();
        Assert.assertTrue(wishListPage.checkTitle());
        softAssert.assertAll();


    }

}
