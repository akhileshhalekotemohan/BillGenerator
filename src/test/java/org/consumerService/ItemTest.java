package org.consumerService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemTest {
    Item item;
    long itemQuantity;
    double itemPrice;
    double expectedValue;
    double actualValue;
    boolean isImported;
    boolean isTaxExempted;
    String itemDescription;
    /**
     * These test cases tests calculateTax() functionality with different possible input in each case
     */
    @Test (description = "Test the functionality of calculateTax method case1")
    public void testCalculateTax1(){
        itemDescription = "imported bottle of perfume";
        itemQuantity = 1;
        itemPrice = 47.50;
        isImported = true;
        isTaxExempted = false;
        expectedValue = 7.15;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test (description = "Test the functionality of roundTax method case2")
    public void testCalculateTax2(){
        itemDescription = "chocolate bar";
        itemQuantity = 1;
        itemPrice = 0.85;
        isImported = false;
        isTaxExempted = true;
        expectedValue = 0.0;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test (description = "Test the functionality of calculateTax method case3")
    public void testCalculateTax3(){
        itemDescription = "music CD";
        itemQuantity = 1;
        itemPrice = 14.99;
        isImported = false;
        isTaxExempted = false;
        expectedValue = 1.50;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test (description = "Test the functionality of calculateTax method case 4")
    public void testCalculateTax4(){
        itemDescription = "book";
        itemQuantity = 1;
        itemPrice = 12.49;
        isImported = false;
        isTaxExempted = true;
        expectedValue = 0.0;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test (description = "Test the functionality of calculateTax method case 5")
    public void testCalculateTax5(){
        itemDescription = "chocolate";
        itemQuantity = 1;
        itemPrice = 0.01;
        isImported = false;
        isTaxExempted = true;
        expectedValue = 0.0;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test (description = "Test the functionality of calculateTax method case 6")
    public void testCalculateTax6(){
        itemDescription = "chocolate";
        itemQuantity = 1;
        itemPrice = 0.01;
        isImported = true;
        isTaxExempted = true;
        expectedValue = 0.0;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test (description = "Test the functionality of calculateTax method case 7")
    public void testCalculateTax7(){
        itemDescription = "chocolate";
        itemQuantity = 4;
        itemPrice = 100.45;
        isImported = true;
        isTaxExempted = true;
        expectedValue = 20.0;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test (description = "Test the functionality of calculateTax method case 8")
    public void testCalculateTax8(){
        itemDescription = "chocolate";
        itemQuantity = 4;
        itemPrice = 100.45;
        isImported = true;
        isTaxExempted = false;
        expectedValue = 60.20;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test (description = "Test the functionality of calculateTax method case 9")
    public void testCalculateTax9(){
        itemDescription = "furniture set";
        itemQuantity = 1;
        itemPrice = 10560.50;
        isImported = false;
        isTaxExempted = false;
        expectedValue = 1056.05;
        item = new Item(itemDescription,itemQuantity,itemPrice,isImported,isTaxExempted);
        item.calculateTotalSalesTax();
        actualValue = item.getTotalTax();
        Assert.assertEquals(actualValue,expectedValue);
    }
}
