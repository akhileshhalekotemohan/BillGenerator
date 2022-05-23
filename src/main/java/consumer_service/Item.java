package consumer_service;
public class Item {
    //class variables to keep track of totalTaxForTheBill and totalAmountOfTheBill
    public static double totalTaxForTheBill;
    public static double totalAmountOfTheBill;
    //constants which defines sales tax @10% and import tax at 5%
    private final double SALES_TAX = 0.10;
    private final double IMPORT_TAX = 0.05;
    //Object varialbes.
    private double salesTax;
    private double importTax;
    private double totalTax;
    private double totalAmountOfTheItemWithTax;
    private final double itemPrice;
    private final long itemQuantity;
    private final boolean isImported;
    private final boolean isTaxExempted;
    private final String itemDescription;

    //Constructor
    Item(String itemDescription, long itemQuantity, double itemPrice,boolean isImported,boolean isTaxExempted) {
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.isImported = isImported;
        this.isTaxExempted = isTaxExempted;
        salesTax = 0.0;
        importTax = 0.0;
        totalTax = 0.0;
        totalAmountOfTheItemWithTax = 0.0;
    }
    //Getters
    public String getItemDescription() {
        return itemDescription;
    }

    public long getItemQuantity() {
        return itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isTaxExempted() {
        return isTaxExempted;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getImportTax() {
        return importTax;
    }

    public double getTotalTax() {
        return totalTax;
    }
    public double getTotalAmountOfTheItemWithTax(){
        return totalAmountOfTheItemWithTax;
    }

    //Setters
    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }
    public void setTotalAmountOfTheItemWithTax(double totalAmountOfTheItemWithTax){
        this.totalAmountOfTheItemWithTax = totalAmountOfTheItemWithTax;
    }

    /**
     * This method calculates total sales tax in these steps
     * Step 1. Calculate sales tax
     * Step 2. Calculate import tax
     * Step 3. Calculate total tax
     * Step 4. Calculate total amount by adding all taxes and price
     * Step 5. Add items total tax to the bills sales tax variable i.e. The purpose of this variable is to show how much sales tax is applied on the bill
     * Step 6. Add items total to the bills total amount variable i.e. The purpose of this variable is to show how much is total amount of the bill
     */
    public void calculateTotalSalesTax(){
        double totalTax;
        double finalPrice;
        //Calculate sales tax
        calculateSalesTax();
        //calculate import tax
        calculateImportTax();
        //Multiply it with quantity to get total tax for all items
        totalTax =  getItemQuantity() * (getSalesTax() + getImportTax());
        setTotalTax(totalTax);

        //Get Total Amount
        finalPrice = getTotalTax() + getItemPrice();
        setTotalAmountOfTheItemWithTax(finalPrice);

        //Update the receipt
        totalTaxForTheBill += getTotalTax();
        totalAmountOfTheBill += getTotalAmountOfTheItemWithTax();
    }

    /**
     * This method calculate sales tax. If the item is exempted from tax it will set it to 0.00. In this example SALES_TAX is set to 10%, but it can be changed.
     * Step 1. Checks if the item is exempted from tax, if yes then it will be set to 0.00 and returns
     * Step 2. Sales tax will be calculated and it will be passed to roundTax() function. roundTax() method performs rounding operation. The returning value from this method will be set to SalesTax variable
     */
    private void calculateSalesTax(){
        double salesTax;
        if(isTaxExempted()) {
            setSalesTax(0.0);
            return;
        }
        salesTax = getItemPrice() * SALES_TAX;
        salesTax = roundTax(salesTax);
        setSalesTax(salesTax);
    }

    /**
     * This method calculates import tax
     * Step 1. Checks if the item is exempted from import tax. If imported then it has import tax otherwise 0.00.
     * Step 2. Import tax will be calculated and it will be passed to roundTax() function. roundTax() function performs rounding operation. The returning value from this method will be set to
     */
    private void calculateImportTax(){
        double importTax;
        if(!isImported()){
            setImportTax(0.0);
            return;
        }
        importTax = getItemPrice() * IMPORT_TAX;
        importTax = roundTax(importTax);
        setImportTax(importTax);
    }
    /**
     * This method prints the current object details in required format
     */
    public void printDetailsForTheItem(){
        String itemDetailsToPrint;
        //Format total amount of the bill to 00.00
        String totalAmount = Utility.formatNumber(getTotalAmountOfTheItemWithTax());

        //print the details of item object in the format <quantity><description>:<totalAmount>
        if(isImported()){
            itemDetailsToPrint = getItemQuantity() + " imported " + getItemDescription() + ": " + totalAmount;
        } else {
            itemDetailsToPrint = getItemQuantity() + " " + getItemDescription() + ": " + totalAmount;
        }
        System.out.println(itemDetailsToPrint);
    }

    /**
     * This method rounds the passed argument to closest 0.05 and returns
     * For given number it calculates the number by 20.0 and rounds it. Now result will be divided by 20.0 to get the actual result.
     * Example : value = 5.265
     *  value * 20.0 --> 5.265 * 20.0 --> 105.3 By rounding this we will get 105. --> value = 105
     *  value / 20.0 --> 5.25. So the final value of value variable 5.25 -->value = 5.25
     * @param value
     * @return
     */
    double roundTax(double value){
        return Math.round(value * 20.0) / 20.0 ;
    }
}
