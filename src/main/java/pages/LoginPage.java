package pages;

import Model.LoginUserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.List;

public class LoginPage extends BasePage{

    By emailField = By.cssSelector("input[data-test='email']");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector("input[data-test='login-submit']");
    private By signInLink = By.cssSelector("a[data-test='nav-sign-in']");
    By usernameError = By.cssSelector("div[data-test='email-error'] > div");
    By passError = By.cssSelector("div[data-test='password-error'] > div");
    By invalidLogin = By.cssSelector("div[data-test='password-error'] > div");

    By userNameInMenu = By.id("user-menu");

    private By myAccountPageTitle = By.cssSelector("h1[data-test='page-title']");
    private By myAccountMenuProfile = By.cssSelector("a[data-test='nav-profile']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginUser(String username, String password){
        typeIn(emailField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
        return this;
    }
    public LoginPage SingleLoginPage(String username, String password){
            clickOnElement(signInLink);
            typeIn(emailField, username);
            typeIn(passwordField, password);
            clickOnElement(loginButton);
        return this;
    }
    public boolean isLoginPassed(){
        System.out.println(usernameError);
        System.out.println(passError);
        System.out.println(invalidLogin);
        if (checkText(usernameError, "E-mail format is invalid.") ||
                checkText(passError, "Password is required.") ||
                checkText(invalidLogin, "Invalid email or password")){
            return true;
        }
        return false;
    }

    public boolean isUserLogged(){
        if (myAccountPageTitle == null){
            return true;
        }
        return false;
    }


}
