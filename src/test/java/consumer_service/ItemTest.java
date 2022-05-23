package consumer_service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemTest {
    /**
     * These test cases tests roundTax() functionality with different possible input in each case
     */
    @Test (description = "Test the functionality of roundTax method case1")
    public void testRoundTax1(){
        Item item = new Item("imported bottle of perfume",1,47.50,true,false);
        item.calculateTotalSalesTax();
        double expectedValue = 7.15;
        double actual = item.roundTax(item.getTotalTax());
        Assert.assertEquals(actual,expectedValue);
    }

    @Test (description = "Test the functionality of roundTax method case2")
    public void testRoundTax2(){
        Item item = new Item("chocolate bar",1,0.85,false,true);
        item.calculateTotalSalesTax();
        double expectedValue = 0.0;
        double actual = item.roundTax(item.getTotalTax());
        Assert.assertEquals(actual,expectedValue);
    }

    @Test (description = "Test the functionality of roundTax method case3")
    public void testRoundTax3(){
        Item item = new Item("music CD",1,14.99,false,false);
        item.calculateTotalSalesTax();
        double expectedValue = 1.50;
        double actual = item.roundTax(item.getTotalTax());
        Assert.assertEquals(actual,expectedValue);
    }

    @Test (description = "Test the functionality of roundTax method case 4")
    public void testRoundTax4(){
        Item item = new Item("book",1,12.49,false,true);
        item.calculateTotalSalesTax();
        double expectedValue = 0.0;
        double actual = item.roundTax(item.getTotalTax());
        Assert.assertEquals(actual,expectedValue);
    }
}
