package consumer_service;

public class BillGenerator {

    public static void main(String[] args){
        //Read input from the user
        User.readDataFromUser();
        //Calculate tax for each item
        User.calculateSalesTax();
        //Print the detailed bill
        User.printBill();

    }
}
