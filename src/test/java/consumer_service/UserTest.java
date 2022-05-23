package consumer_service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {

    @Test(description = "test calculate method does what it is intended to do")
    public void testCalculateTaxMethod(){
        Item item = new Item("box of chocolate",1,5.60,true,true);
        double expected = 0.30;
        double actual;
        User.queue.add(item);
        User.calculateSalesTax();
        actual = item.getTotalTax();
        Assert.assertEquals(actual,expected);
    }
}
