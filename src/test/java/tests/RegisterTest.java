package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{


    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeMethod
    public void localSetup(){
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void registerUserTest() throws InterruptedException {
        registerPage.goToRegisterPage()
                .registerUser();
        Thread.sleep(2000);
        loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());

        softAssert.assertTrue(registerPage.isUserRegistered());
        softAssert.assertAll();

    }


}
