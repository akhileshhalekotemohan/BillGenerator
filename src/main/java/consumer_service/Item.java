package consumer_service;
public class Item {
    private final String itemDescription;
    private final long itemQuantity;
    private final double itemPrice;
    private final boolean isImported;
    private final boolean isTaxExempted;
    private double salesTax;
    private double importTax;
    private double totalTax;
    public static double totalTaxForTheBill;
    private final double SALES_TAX = 0.10;
    private final double IMPORT_TAX = 0.05;

    Item(String itemDescription, long itemQuantity, double itemPrice,boolean isImported,boolean isTaxExempted) {
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.isImported = isImported;
        this.isTaxExempted = isTaxExempted;
        salesTax = 0.0;
        importTax = 0.0;
        totalTax = 0.0;
    }

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

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public void calculateTotalSalesTax(){
        //Calculate total sales tax
        calculateSalesTax();
        calculateImportTax();
        setTotalTax(getSalesTax() + getImportTax());
        totalTaxForTheBill += getTotalTax();
    }

    private void calculateSalesTax(){
        //Calculate just sales tax
        if(isTaxExempted()) {
            setSalesTax(0.0);
            return;
        }
        setSalesTax(getItemPrice() * SALES_TAX * getItemQuantity());
    }

    private void calculateImportTax(){
        //Calculate import tax
        if(!isImported()){
            setImportTax(0.0);
            return;
        }

        setImportTax(getItemPrice() * IMPORT_TAX * getItemQuantity());
    }

}
