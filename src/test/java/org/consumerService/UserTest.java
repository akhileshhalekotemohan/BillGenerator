package org.consumerService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {
    Item item;
    double expectedValue;
    double actualValue;
    double itemPrice;
    long itemQuantity;
    boolean isImported;
    boolean isTaxExempted;
    String itemDescription;

    /**
     * Here we are testing calculateSalesTax() in User class with only one input to test integration. In depth coverage is done in ItemTest class
     */
    @Test(description = "test calculateSalesTax() method does what it is intended to do")
    public void testCalculateTaxMethod(){
        itemDescription = "box of chocolate";
        itemQuantity = 1;
        itemPrice = 5.60;
        isImported = true;
        isTaxExempted = true;
        item = new Item(itemDescription,1,5.60,true,true);
        expectedValue = 0.30;
        User.queue.add(item);
        User.calculateSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }
}
