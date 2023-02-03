package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FilterPage extends BasePage{

    By categoryBtn = By.cssSelector("a[data-test='nav-categories']");
    By powerToolCat = By.cssSelector("a[href='#/category/power-tools']");
    By drillCheck = By.cssSelector("input[value='11']");
    By cards = By.cssSelector(".container .card");
    By filteredCards = By.cssSelector("div[data-test='filter_completed'] > a");
    List<WebElement> list = null;
    List<WebElement> newList = null;
    int numberOfCards = 0;
    int numberOfFilteredCards = 0;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public void filterList(){


        clickOnElement(categoryBtn);
        clickOnElement(powerToolCat);

        list = getElementList(cards);
        numberOfCards = list.size();
        numberOfFilteredCards = 0;

        clickOnElement(drillCheck);
        newList = getElementList(filteredCards);
        numberOfFilteredCards = newList.size();


    }
    public boolean checksTwoLists (){
        System.out.println(numberOfCards);
        System.out.println(numberOfFilteredCards);
        if (numberOfCards > numberOfFilteredCards){
            return true;
        }
        return false;
    }

}
