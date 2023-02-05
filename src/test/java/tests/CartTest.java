package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.RegisterPage;

public class CartTest extends BaseTest {

    LoginPage loginPage;
    RegisterPage registerPage;
    CartPage cartPage;

    @BeforeMethod
    public void localSetup(){
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void addProductToWishList() throws InterruptedException {
        registerPage.goToRegisterPage()
                .registerUser();
        Thread.sleep(2000);
        loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());

        softAssert.assertTrue(registerPage.isUserRegistered());

        cartPage.addToCart();
        softAssert.assertTrue(cartPage.checkCart());
        cartPage.continuePayment();
        softAssert.assertTrue(cartPage.isPaymentSuccess());
        softAssert.assertAll();
    }
}
