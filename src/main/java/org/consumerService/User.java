package org.consumerService;
import java.util.*;

public class User {
    public static Queue<Item> queue = new LinkedList<>();
    /**
     * This method reads data from the user,converts each line to an item object and adds each item in to a queue
     */
    public static void readDataFromUser(){
        Item item;
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Please enter item details / type 'quit' to exit");
        System.out.println("Format: <quantity> <imported(optional)> <description> at <price>");
        System.out.println("Ex: '1 imported box of chocolates at 10.00'");
        System.out.println("Please type 'done' to stop adding new items and print bill with sales tax!");
        System.out.println("");
        userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("quit")){ //If true user has entered quit so this will quit the program
            System.out.println("The program has ended. Bye!");
            System.exit(0);
        }

        while(true){
            if(userInput.equalsIgnoreCase("done")){ //If user has entered 'done' that means no more adding
                break;                                          //of items to the bill so stop reading from input stream
            }
            item = Utility.scrapeDetails(userInput);
            if(item != null){ //null means there was a problem fetching data from input string, so object was not created
                queue.add(item);
            }
            userInput = scanner.nextLine();
        }
    }

    /**
     * This method invokes sales tax calculation method for all item objects in the queue
     */
    public static void calculateSalesTax(){
        for(Item item:queue){  //It traverses over all items in the queue and calculates tax for all items
            item.calculateTotalSalesTax();
        }
    }

    /**
     * This method prints itemized bill for each item objects
     */
    public static void printBill(){
        Item item;
        System.out.println("");
        if(queue.isEmpty()){
            System.out.println("No items have been added so quitting. Bye!");
            return;
        }
        System.out.println("--------------- Final Bill ----------------");
        while(true){
            item = queue.poll(); //Get the first item from the queue
            if(item == null){ //null means queue is empty or all items have been removed
                break;
            }
            item.printDetailsForTheItem();
        }
        System.out.println("Sales Taxes :"+Utility.formatNumber(Item.totalTaxForTheBill));
        System.out.println("Total: "+Utility.formatNumber(Item.totalAmountOfTheBill));
        System.out.println("-------------------------------------------");
        if(!Utility.errorMessages.isEmpty()){ //This contains malformed strings which were not considered for the bill
            System.out.println("");           //printing it just for information
            System.out.println("These strings were not parsed");
            for(String s:Utility.errorMessages.split("\n")){
                System.out.println(s);
            }
        }
    }
}
