package org.consumerService;
import java.text.DecimalFormat;
import java.util.Set;

public class Utility {

    //List of exempted items from tax.
    private static final Set<String> itemsExemptedList = Set.of("books","chocolates","cookies","medicines","pills");
    public static String errorMessages = "";
    /**
     * This method takes a string and scrapes details from it and returns an object which is built from scraped details
      * @param description - String provided to the function
     * @return Item object if success else null
     */
    public static Item scrapeDetails(String description){
        //Variables used in fetching details
        String[] descriptionString;
        String itemDescription = "";
        String regExForSplit = " ";
        long itemQuantity;
        double itemPrice;
        boolean isImported;
        boolean isExempted;
        //Split string and store it in to an array of string. Before split just clean any trailing and leading zeroes and unwanted strings
        descriptionString = cleanString(description).split(regExForSplit);
        try{
            //First item should be quantity, so fetch and store into itemQuantity
            itemQuantity = Long.parseLong(descriptionString[0]);
            itemPrice = Double.parseDouble(descriptionString[descriptionString.length - 1]);
            isImported = isImported(description);
            isExempted = isItemExemptedFromTax(descriptionString);

            //Check size of string array. Less than or equal 2 means it does not have any description
            if(descriptionString.length <= 2){
                throw new NumberFormatException();
            }
            //Loop through string array to build item description
            for(int i=1;i<descriptionString.length-1;i++){
                itemDescription = itemDescription + " " + descriptionString[i];
            }
            itemDescription = itemDescription.trim();
            //build an object and return it to the calling function
            return new Item(itemDescription,itemQuantity,itemPrice,isImported,isExempted);

        } catch (NumberFormatException ne){ // If there is a problem in fetching values from string this will raise Number Format Exception which will be caught here
            //System.out.println("The string is malformed so please correct the format. Exception object : "+ne);
            errorMessages += description + "\n";
        } //After the Number Format Exception caught, null will be returned to the calling function
        return null;
    }

    /**
     * This method checks whether description contains regex string or pattern.
     * @param regex - either regex or string
     * @param description - description of the item
     * @return true if description contains regex else false
     */
    public static boolean isPresent(String regex,String description){
        return description.contains(regex);
    }

    /**
     * This method checks if the description string contains 'imported' substring
     * @param description - description of the item
     * @return true if 'imported' substring is present
     */
    public static boolean isImported(String description){
        return isPresent("imported",description);
    }

    /**
     * This method checks if the item is exempted from tax.
     * @param descriptionString - String array
     * @return true if it is present in the itemsExemptedList else false
     */
    public static boolean isItemExemptedFromTax(String[] descriptionString){
        //Loop over this string array to check if list contains any word in the string
        for (String s : descriptionString) {
            if (itemsExemptedList.contains(s) || itemsExemptedList.contains(s+"s")) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method removes unwanted substrings from the description
     * @param string - string name
     * @return - altered string without unwanted substrings
     */
    public static String cleanString(String string){
        //replaces ' at' and ' imported' from the description
        string = string.replace(" at","");
        string = string.replace(" imported","");
        string = string.trim();
        return string;
    }

    /**
     * This method formats the number required format and returns it
     * @param value - number we want to format
     * @return - formatted number but type will be changed to string
     */
    public static String formatNumber(double value){
        DecimalFormat decimalFormat = new DecimalFormat("##0.00");
        return decimalFormat.format(value);
    }

}
