package org.consumerService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UtilityTest {
    String description;
    Item itemObject;
    String expectedVal;
    String actualVal;
    String expectedDescription;
    String actualDescription;
    long expectedItemQuantity;
    long actualItemQuantity;
    double expectedItemPrice;
    double actualItemPrice;
    boolean expected;
    boolean actual;
    /**
     * These testcases are testing scrapeDetails() method with different possible inputs. Each case has unique input.
     */
    @Test (description = "Verify functionality of scrapeDetails() case 1")
    public void testScrapeDetails1(){
        description = "1 imported bottle of perfume at 27.99 ";
        expectedDescription = "bottle of perfume";
        expectedItemQuantity = 1;
        expectedItemPrice = 27.99;
        itemObject = Utility.scrapeDetails(description);
        if(itemObject == null){
            Assert.fail("Item object was not created");
        }
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);
    }
    @Test (description = "Verify functionality of scrapeDetails() case 2")
    public void testScrapeDetails2(){
        description = "1 imported bottle of perfume at 10027.99 ";
        expectedDescription = "bottle of perfume";
        expectedItemQuantity = 1;
        expectedItemPrice = 10027.99;
        itemObject = Utility.scrapeDetails(description);
        if(itemObject == null){
            Assert.fail("Item object was not created");
        }
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }
    @Test (description = "Verify functionality of scrapeDetails() case 3")
    public void testScrapeDetails3(){
        description = "1 Nike mens after shave gel and shaving cream special ocean blue flavor and free voucher limited edition imported at 127.99 ";
        expectedDescription = "Nike mens after shave gel and shaving cream special ocean blue flavor and free voucher limited edition";
        expectedItemQuantity = 1;
        expectedItemPrice = 127.99;
        itemObject = Utility.scrapeDetails(description);
        if(itemObject == null){
            Assert.fail("Item object was not created");
        }
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }
    @Test (description = "Verify functionality of scrapeDetails() case 4")
    public void testScrapeDetails4(){
        description = "1 Nike mens after shave gel and shaving cream special ocean @25% off blue flavor and free voucher limited edition imported at 127.99";
        expectedDescription = "Nike mens after shave gel and shaving cream special ocean @25% off blue flavor and free voucher limited edition";
        expectedItemQuantity = 1;
        expectedItemPrice = 127.99;
        itemObject = Utility.scrapeDetails(description);
        if(itemObject == null){
            Assert.fail("Item object was not created");
        }
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }
    @Test (description = "Verify functionality of scrapeDetails() case 5")
    public void testScrapeDetails5(){
        description = "1 CHOCO(**(&&^%%^$##^$^%$ at 127.99 ";
        expectedDescription = "CHOCO(**(&&^%%^$##^$^%$";
        expectedItemQuantity = 1;
        expectedItemPrice = 127.99;
        itemObject = Utility.scrapeDetails(description);
        if(itemObject == null){
            Assert.fail("Item object was not created");
        }
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }
    @Test (description = "Verify functionality of scrapeDetails() case 6")
    public void testScrapeDetails6(){
        description = "1 imported bottle of perfume at 0.99 ";
        expectedDescription = "bottle of perfume";
        expectedItemQuantity = 1;
        expectedItemPrice = 0.99;
        itemObject = Utility.scrapeDetails(description);
        if(itemObject == null){
            Assert.fail("Item object was not created");
        }
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }
    @Test (description = "Verify functionality of scrapeDetails() case 7")
    public void testScrapeDetails7(){
        description = "1 imported bottle of perfume at 0.99 best price";
        itemObject = Utility.scrapeDetails(description);
        if(itemObject != null){
            Assert.fail("Object is not null");
        }
    }
    @Test (description = "Verify functionality of scrapeDetails() case 8")
    public void testScrapeDetails8(){
        description = "1.01 imported bottle of perfume at 27.99";
        itemObject = Utility.scrapeDetails(description);
        if(itemObject != null){
            Assert.fail("Object is not null");
        }
    }
    @Test (description = "Verify functionality of scrapeDetails() case 9")
    public void testScrapeDetails9(){
        description = "imported 1 bottle of perfume at 27.99";
        itemObject = Utility.scrapeDetails(description);
        if(itemObject != null){
            Assert.fail("Object is not null");
        }
    }
    @Test (description = "Verify functionality of scrapeDetails() case 10")
    public void testScrapeDetails10(){
        description = "qty - 1 box of chocolates at 22";
        itemObject = Utility.scrapeDetails(description);
        if(itemObject != null){
            Assert.fail("Object is not null");
        }
    }
    @Test (description = "Verify functionality of scrapeDetails() case 11")
    public void testScrapeDetails11(){
        description = "";
        itemObject = Utility.scrapeDetails(description);
        if(itemObject != null){
            Assert.fail("Object is not null");
        }
    }
    @Test (description = "Verify functionality of scrapeDetails() case 12")
    public void testScrapeDetails12(){
        description = "1 at 27.99 ";
        itemObject = Utility.scrapeDetails(description);
        if(itemObject != null){
            Assert.fail("Object is not null");
        }
    }
    @Test (description = "Verify functionality of scrapeDetails() case 13")
    public void testScrapeDetail13(){
        description = " 21 imported bottle of perfume at 0.99 ";
        expectedDescription = "bottle of perfume";
        expectedItemQuantity = 21;
        expectedItemPrice = 0.99;
        itemObject = Utility.scrapeDetails(description);
        if(itemObject == null){
            Assert.fail("Item object was not created");
        }
        actualDescription = itemObject.getItemDescription();
        actualItemQuantity = itemObject.getItemQuantity();
        actualItemPrice = itemObject.getItemPrice();
        Assert.assertEquals(actualDescription,expectedDescription);
        Assert.assertEquals(actualItemQuantity,expectedItemQuantity);
        Assert.assertEquals(actualItemPrice,expectedItemPrice);

    }
    /**
     * These testcases tests isPresent() method with different possible input
     */
    @Test (description = "Verify functionality of isPresent method case1")
    public void testIsPresent1(){
        actual = Utility.isPresent("This","This is a testcase");
        expected = true;
        Assert.assertEquals(actual,expected);
    }
    @Test (description = "Verify functionality of isPresent method case2")
    public void testIsPresent2(){
        actual = Utility.isPresent("this","This is a testcase");
        expected = false;
        Assert.assertEquals(actual,expected);
    }
    @Test (description = "Verify functionality of isPresent method case3")
    public void testIsPresent3(){
        actual = Utility.isPresent("test case","This is a testcase");
        expected = false;
        Assert.assertEquals(actual,expected);
    }
    @Test (description = "Verify functionality of isPresent method case4")
    public void testIsPresent4(){
        actual = Utility.isPresent("not related","This is a testcase");
        expected = false;
        Assert.assertEquals(actual,expected);
    }
    /**
     * These test cases test isExemptedFromTax() functionality with different possible input in each case
     */
    @Test (description = "Verify functionality of isExempted method case1")
    public void testIsExemptedFromTax1(){
        String[] testString = {"1","imported","box","of","chocolates","9.99"};
        actual = Utility.isItemExemptedFromTax(testString);
        expected = true;
        Assert.assertEquals(actual,expected);
    }
    @Test (description = "Verify functionality of isExempted method case2")
    public void testIsExemptedFromTax2(){
        String[] testString = {"1","book","9.99"};
        actual = Utility.isItemExemptedFromTax(testString);
        expected = true;
        Assert.assertEquals(actual,expected);
    }
    /**
     * These test cases tests cleanString() method with different possible inputs in each case
     */
    @Test (description = "Verify functionality of cleanString method case1")
    public void testCleanString1(){
        actualVal = Utility.cleanString("  1 imported box of chocolates at 10.99 ");
        expectedVal = "1 box of chocolates 10.99";
        Assert.assertEquals(actualVal,expectedVal);
    }
    @Test (description = "Verify functionality of cleanString method case2")
    public void testCleanString2(){
        actualVal = Utility.cleanString("1 box of chocolates 10.99");
        expectedVal = "1 box of chocolates 10.99";
        Assert.assertEquals(actualVal,expectedVal);
    }
    /**
     * These test cases tests formatNumber() method with different possible inputs in each case
     */
    @Test (description = "Verify functionality of formatNumber method case1")
    public void testFormatNumber1(){
        actualVal = Utility.formatNumber(10.54444);
        expectedVal = "10.54";
        Assert.assertEquals(actualVal,expectedVal);
    }
    @Test (description = "Verify functionality of formatNumber method case2")
    public void testFormatNumber2(){
        actualVal = Utility.formatNumber(10.5);
        expectedVal = "10.50";
        Assert.assertEquals(actualVal,expectedVal);
    }
    @Test (description = "Verify functionality of formatNumber method case3")
    public void testFormatNumber3(){
        actualVal = Utility.formatNumber(0.001);
        expectedVal = "0.00";
        Assert.assertEquals(actualVal,expectedVal);
    }
    @Test (description = "Verify functionality of formatNumber method case4")
    public void testFormatNumber4(){
        actualVal = Utility.formatNumber(10000);
        expectedVal = "10000.00";
        Assert.assertEquals(actualVal,expectedVal);
    }
}
