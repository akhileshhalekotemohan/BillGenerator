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
        System.out.println("Ex: '1 imported box of chocolates at 10.00'");
        System.out.println("Please type 'done' to stop adding new items and print bill with sales tax!");
        userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("quit")){
            System.out.println("The program has ended. Bye!");
            System.exit(0);
        }

        while(true){
            //System.out.println("working with the input line :"+userInput);
            if(userInput.equalsIgnoreCase("done")){
                break;
            }
            item = Utility.scrapeDetails
                    (userInput);
            if(item != null){
                queue.add(item);
            }
            userInput = scanner.nextLine();
        }
    }

    /**
     * This method invokes sales tax calculation method for all item objects in the queue
     */
    public static void calculateSalesTax(){
        //System.out.println("Calculating sales tax");
        for(Item item:queue){
            //System.out.println("Calculating sales tax for an item");
            item.calculateTotalSalesTax();
        }
    }

    /**
     * This method prints itemized bill
     */
    public static void printBill(){
        Item item;
        if(queue.isEmpty()){
            System.out.println("No items have been added so quitting. Bye!");
            return;
        }
        while(true){
            item = queue.poll();
            if(item == null){
                break;
            }
            item.printDetailsForTheItem();
        }
        System.out.println("Sales Taxes :"+Utility.formatNumber(Item.totalTaxForTheBill));
        System.out.println("Total: "+Utility.formatNumber(Item.totalAmountOfTheBill));

        //Printing unparsed strings
        if(!Utility.errorMessages.isEmpty()){
            System.out.println("");
            System.out.println("These strings were not parsed");
            for(String s:Utility.errorMessages.split("\n")){
                System.out.println(s);
            }
        }
    }

}
