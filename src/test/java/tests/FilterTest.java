package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FilterPage;

public class FilterTest extends BaseTest {

    FilterPage filterPage;

    @BeforeMethod
    public void localSetup(){
        filterPage = new FilterPage(driver);
    }

    @Test
    public void FilterTest(){

        filterPage.filterList();
        Assert.assertTrue(filterPage.checksTwoLists());


    }

}
