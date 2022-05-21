package consumer_service;
import java.util.*;

public class User {
    public static Queue<Item> queue = new LinkedList<>();
    public static void readDataFromUser(){
        Item item;
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter item details in the format below / type 'quit' to exit");
        System.out.println("<quantity> <imported(optional as this appliers only to imported items)> <description> at <price>");
        System.out.println("Few Examples for your reference");
        System.out.println("1 imported box of chocolates at 10.00");
        System.out.println("10 books at 12.49");
        System.out.println("Please type 'done' to stop adding new items and print bill with sales tax!");
        userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("quit")){
            System.out.println("The program has ended. Bye!");
            System.exit(0);
        }

        while(true){
            userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("done")){
                break;
            }
            item = FetchItemDetails.scrapeDetails(userInput);
            if(item != null){
                queue.add(item);
            }
        }
    }

    public static void calculateSalesTax(){
        for(Item item:queue){
            item.calculateTotalSalesTax();
        }
    }

    public static void printBill(){
        Item item;
        String itemDescription;
        double itemPrice;
        long itemQuantity;
        long totalBillAmount = 0;
        if(queue.isEmpty()){
            System.out.println("No items have been added so quitting. Bye!");
            return;
        }
        while(true){
            item = queue.poll();
            if(item == null){
                break;
            }
            itemDescription = item.getItemDescription();
            itemQuantity = item.getItemQuantity();
            itemPrice = item.getItemPrice() + item.getTotalTax();
            totalBillAmount += itemPrice;
            System.out.println(itemQuantity + " "+ itemDescription + ": " + itemPrice);
        }
        System.out.println("Sales Taxes :"+Item.totalTaxForTheBill);
        System.out.println("Total: "+totalBillAmount);
    }

}
