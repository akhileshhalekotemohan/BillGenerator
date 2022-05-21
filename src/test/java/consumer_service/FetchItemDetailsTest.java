package consumer_service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FetchItemDetailsTest {
    FetchItemDetails fetchItemDetails;
    final String REG_EX_NAME = "([a-zA-Z]+[\\s]?)+";
    final String REG_EX_QTY = "(^[\\d]+[\\s]+)";
    final String REG_EX_PRICE = "([\s]?[\\d]+[\\.][\\d]+)";
    String description;
    String expected;
    String actual;
    Item itemObject;
    String expectedDescription;
    long expectedItemQuantity;
    double expectedItemPrice;
    String actualDescription;
    long actualItemQuantity;
    double actualItemPrice;

    @Test (description = "Verify functionality of test fetch value from description for item name case 1")
    public void testfetchValueFromDescriptionForName1(){
        description = "1 imported bottle of perfume at 27.99 ";
        expected = "imported bottle of perfume at";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_NAME,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of test fetch value from description for item name case 2")
    public void testfetchValueFromDescriptionForName2(){
        description = "1 perfume at 27.99 ";
        expected = "perfume at";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_NAME,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of test fetch value from description for item name case 3")
    public void testfetchValueFromDescriptionForName3(){
        description = "1 at 27.99 ";
        expected = "";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_NAME,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of test fetch value from description for item name case 4")
    public void testfetchValueFromDescriptionForName4(){
        description = "1 Nike mens after shave gel and shaving cream special ocean blue flavor and free voucher limited edition imported at 127.99 ";
        expected = "Nike mens after shave gel and shaving cream special ocean blue flavor and free voucher limited edition imported";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_NAME,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of test fetch value from description for item name case 5")
    public void testfetchValueFromDescriptionForName5(){
        description = "1 Nike mens after shave gel and shaving cream special ocean @25% off blue flavor and free voucher limited edition imported at 127.99 ";
        expected = "off blue flavor and free voucher limited edition imported";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_NAME,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of test fetch value from description for item name case 5")
    public void testfetchValueFromDescriptionForName6(){
        description = "1 CHOCO(**(&&^%%^$##^$^%$ at 127.99 ";
        expected = "CHOCO";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_NAME,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of test fetch value from description for Price case 1")
    public void testfetchValueFromDescriptionForPrice1(){
        description = "1 imported bottle of perfume at 27.99 ";
        expected = "27.99";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_PRICE,description);
        Assert.assertEquals(actual,expected);
    }
    @Test (description = "Verify functionality of test fetch value from description for Price case 2")
    public void testfetchValueFromDescriptionForPrice2(){
        description = "1 imported bottle of perfume at 10027.99 ";
        expected = "10027.99";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_PRICE,description);
        Assert.assertEquals(actual,expected);
    }
    @Test (description = "Verify functionality of test fetch value from description for Price case 3")
    public void testfetchValueFromDescriptionForPrice3(){
        description = "1 imported bottle of perfume at 0.99 ";
        expected = "0.99";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_PRICE,description);
        Assert.assertEquals(actual,expected);
    }
    @Test (description = "Verify functionality of test fetch value from description for Price case 4")
    public void testfetchValueFromDescriptionForPrice4(){
        description = "1 imported bottle of perfume at 0.99 best price";
        expected = "0.99";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_PRICE,description);
        Assert.assertEquals(actual,expected);
    }
    @Test (description = "Verify functionality of test fetch value from description for Quantity case 1")
    public void testfetchValueFromDescriptionForQuantity1(){
        description = "1 imported bottle of perfume at 27.99 ";
        expected = "1";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_QTY,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of test fetch value from description for Quantity case 2")
    public void testfetchValueFromDescriptionForQuantity2(){
        description = "1.01 imported bottle of perfume at 27.99 ";
        expected = "";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_QTY,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of test fetch value from description for Quantity case 3")
    public void testfetchValueFromDescriptionForQuantity3(){
        description = "imported 1 bottle of perfume at 27.99 ";
        expected = "";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_QTY,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of fetchValueFromDescription() for Quantity case 3")
    public void testfetchValueFromDescriptionForQuantity4(){
        description = "qty - 1 box of chocolates at 22";
        expected = "";
        actual = fetchItemDetails.fetchValueFromDescription(REG_EX_QTY,description);
        Assert.assertEquals(actual,expected);
    }

    @Test (description = "Verify functionality of scrapedetails() case 1")
    public void testScrapeDetails1(){
        description = "1 imported bottle of perfume at 27.99 ";
        expectedDescription = "imported bottle of perfume";
        expectedItemQuantity = 1;
        expectedItemPrice = 27.99;
        itemObject = fetchItemDetails.scrapeDetails(description);
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }

    @Test (description = "Verify functionality of scrapedetails() case 2")
    public void testScrapeDetails2(){
        description = "1 perfume at 27.99 ";
        expectedDescription = "perfume";
        expectedItemQuantity = 1;
        expectedItemPrice = 27.99;
        itemObject = fetchItemDetails.scrapeDetails(description);
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }

    @Test (description = "Verify functionality of scrapedetails() case 3")
    public void testScrapeDetails3(){
        description = "1 Nike mens after shave gel and shaving cream special ocean blue flavor and free voucher limited edition imported at 127.99 ";
        expectedDescription = "Nike mens after shave gel and shaving cream special ocean blue flavor and free voucher limited edition imported";
        expectedItemQuantity = 1;
        expectedItemPrice = 127.99;
        itemObject = fetchItemDetails.scrapeDetails(description);
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }




    //
    //description = "1 at 27.99 "; //Fails as expected
    //
    //description = "1 Nike mens after shave gel and shaving cream special ocean @25% off blue flavor and free voucher limited edition imported at 127.99 ";
    //description = "1 CHOCO(**(&&^%%^$##^$^%$ at 127.99 ";
    //description = "1 imported bottle of perfume at 10027.99 ";
    //description = "1 imported bottle of perfume at 0.99 ";
    //description = "1 imported bottle of perfume at 0.99 best price";
    //description = "1.01 imported bottle of perfume at 27.99 ";
    //description = "imported 1 bottle of perfume at 27.99 ";
    //description = "qty - 1 box of chocolates at 22";



}
