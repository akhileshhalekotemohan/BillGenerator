package consumer_service;

public class BillGenerator {

    public static void main(String[] args){

        User.readDataFromUser();
        User.calculateSalesTax();
        User.printBill();

    }
}
