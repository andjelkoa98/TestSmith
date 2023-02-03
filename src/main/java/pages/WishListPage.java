package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage {


    By homeLink = By.cssSelector("a[data-test='nav-home']");
    By product = By.cssSelector("a[data-test='product-1']");
    By addToFavoritesBtn = By.cssSelector("button[data-test='add-to-favorites']");
    By userMenu = By.cssSelector("a[id='user-menu']");
    By myFavorites = By.cssSelector("a[data-test='nav-my-favorites']");
    By productTitle = By.cssSelector("h5[data-test='product-name']");
    String text;

    public WishListPage(WebDriver driver) {
        super(driver);
    }


    public void addProduct(){
        clickOnElement(homeLink);
        clickOnElement(product);
        clickOnElement(addToFavoritesBtn);
        clickOnElement(userMenu);
        clickOnElement(myFavorites);
        text = getElement(productTitle).getText();
    }

    public boolean checkTitle(){
        if (!text.isEmpty()){
            return true;
        }
        return false;
    }

}
