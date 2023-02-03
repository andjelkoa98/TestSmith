package tests;

import Model.LoginUserModel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.util.List;


public class LoginTest extends BaseTest{

    LoginPage loginPage;


    @BeforeMethod
    public void localSetup(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void singleLoginUserTest(){
        List<LoginUserModel> list = Utils.getDataFromJson();
        for (int i = 0; i < list.size(); i++) {
            loginPage.SingleLoginPage(list.get(i).getUsername(),list.get(i).getPassword());
            softAssert.assertTrue(loginPage.isLoginPassed());
            softAssert.assertAll();
        }

    }

}
