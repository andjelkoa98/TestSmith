package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    By homeLink = By.cssSelector("a[data-test='nav-home']");
    By product1 = By.cssSelector("a[data-test='product-1']");
    By product2 = By.cssSelector("a[data-test='product-2']");
    By increaseBtn = By.cssSelector("button[id='btn-increase-quantity']");
    By addToCartBtn = By.cssSelector("button[id='btn-add-to-cart']");
    By cart = By.cssSelector("a[data-test='nav-cart']");
    By cartNumber = By.cssSelector("a[data-test='nav-cart'] span");
    By productsQuantity = By.cssSelector("input[class='form-control quantity']");
    By productPrices = By.cssSelector("tbody tr td:nth-child(4)");
    By pricesQuantity = By.cssSelector("tbody tr td:nth-child(5)");
    By totalPrice = By.cssSelector("tfoot tr td:nth-child(5)");
    By proceedCheckout1 = By.cssSelector("aw-wizard-step[steptitle='Cart'] button[class='btn btn-success']");
    By proceedCheckout2 = By.cssSelector("aw-wizard-step[steptitle='Sign in'] button[class='btn btn-success']");
    By proceedCheckout3 = By.cssSelector("aw-wizard-step[steptitle='Address'] button[class='btn btn-success']");
    By paymentOption = By.cssSelector("select[id='payment-method']");
    By optionTwo = By.cssSelector("option[value='2: Cash on Delivery']");
    By accountName = By.cssSelector("input[data-test='account-name']");
    By accountNumber = By.cssSelector("input[data-test='account-number']");
    By btnConfirm = By.cssSelector("button[data-test='finish']");
    By success = By.cssSelector("div[class='help-block']");
    int numberInCart = 0;
    List<WebElement> listQuantity = null;
    List<WebElement> listPrices = null;
    List<WebElement> listTotalPrices = null;
    double total = 0;
    int sumOfQuantities = 0;

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void addToCart(){
        clickOnElement(homeLink);
        clickOnElement(product1);
        clickOnElement(increaseBtn);
        clickOnElement(addToCartBtn);
        clickOnElement(homeLink);
        clickOnElement(product2);
        clickOnElement(addToCartBtn);
        clickOnElement(cart);
        numberInCart = Integer.parseInt(getElement(cartNumber).getText());
        listQuantity = getElementList(productsQuantity);
        listPrices = getElementList(productPrices);
        listTotalPrices = getElementList(pricesQuantity);
        total = Double.parseDouble(getElement(totalPrice).getText().replace("$",""));
    }
    public void continuePayment(){
        clickOnElement(proceedCheckout1);
        clickOnElement(proceedCheckout2);
        clickOnElement(proceedCheckout3);
        clickOnElement(paymentOption);
        clickOnElement(optionTwo);
        typeIn(accountName, "Aca");
        typeIn(accountNumber, "21345");
        clickOnElement(btnConfirm);
    }

    public boolean checkCart (){
        double sumOfTotalPricesFromList = 0;
        for (int i = 0; i < listQuantity.size(); i++) {
            int oneProductQuantity = Integer.parseInt(listQuantity.get(i).getAttribute("value"));
            sumOfQuantities+=oneProductQuantity;
            double oneProductPrice = Double.parseDouble(listPrices.get(i).getText().replace("$",""));
            double oneProductTotalPrice = oneProductQuantity * oneProductPrice;
            double totalPriceFromList = Double.parseDouble(listTotalPrices.get(i).getText().replace("$",""));
            sumOfTotalPricesFromList += totalPriceFromList;
            if (sumOfQuantities == numberInCart && oneProductTotalPrice == totalPriceFromList && sumOfTotalPricesFromList == total){
                return true;
            }
        }
        return false;
    }
    public boolean isPaymentSuccess(){
        if (getElement(success).getText().equals("Payment was successful")){
            return true;
        }
        return false;
    }
}
