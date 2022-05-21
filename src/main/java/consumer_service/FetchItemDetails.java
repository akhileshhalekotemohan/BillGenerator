package consumer_service;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FetchItemDetails {
    //public static final String REG_EX_ITEM_QUANTITY = "([\\d]+[\\s]+)";
    //public static final String REG_EX_ITEM_PRICE = "([a-zA-Z|\\s]+)";
    //public static final String REG_EX_ITEM_DESCRIPTION = "([\s]?[\\d]+[\\.][\\d]+)";
    //final String REG_EX_NAME = "([a-zA-Z]+[\\s]?)+";
    //final String REG_EX_QTY = "(^[\\d]+[\\s]+)";
    //final String REG_EX_PRICE = "([\s]?[\\d]+[\\.][\\d]+)";
    public static final String REG_EX_ITEM_QUANTITY = "(^[\\d]+[\\s]+)";
    public static final String REG_EX_ITEM_PRICE = "[at\s?]([\s]?[\\d]+[\\.][\\d]+)";
    public static final String REG_EX_ITEM_DESCRIPTION = "([a-zA-Z]+[\\s]?)+";


    private static final Set<String> itemsExemptedList = Set.of("books","chocolates","cookies","medicine","pills");


    /**
     * @param description - description provided by the user
     * @return - Item object if success otherwise null
     * This method scrapes information from the description and builds an item object which will be used for generating itemized bills later
     */
    public static Item scrapeDetails(String description){
        long itemQuantity;
        double itemPrice;
        boolean isImported;
        boolean isExempted;
        String itemDescription;
        try{
            itemDescription = fetchValueFromDescription(REG_EX_ITEM_DESCRIPTION,description);
            if(itemDescription.isEmpty()){
                throw new NumberFormatException();
            }
            itemQuantity = Long.parseLong(fetchValueFromDescription(REG_EX_ITEM_QUANTITY,description));
            itemPrice = Double.parseDouble(fetchValueFromDescription(REG_EX_ITEM_PRICE,description));
            isImported = isPresent("imported",description);
            isExempted = isItemExemptedFromTax(description);
            return new Item(itemDescription,itemQuantity,itemPrice,isImported,isExempted);
        } catch (NumberFormatException ne){
            System.out.println("The string is malformed so please correct the format. Exception object : "+ne);
        }
        return null;
    }

    /**
     * This method scrapes and returns string which matches with regex
      * @param regex is a pattern that we want to match
     * @param description is a string which is provided by the user
     * @return returns matching word from the string only if there is a match else returns null string
     */
    public static String fetchValueFromDescription(String regex, String description){
        String value = "";
        description = description.replace("at","");
        //System.out.println(description);
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(description);
        //System.out.println("Starting with matching");
        while(matcher.find()){
            value = matcher.group(0).trim();
        }
        if(isPresent("at",value)){
            System.out.println("The string has at in it. This is the string: "+value);
            value.replace("at","");
        }
        return value;
    }

    /**
     * This method checks whether description contains regex string or pattern.
     * @param regex - either regex or string
     * @param description - description of the item
     * @return true if description contains regex else false
     */
    public static boolean isPresent(String regex,String description){
        //return description.indexOf(regex) != -1;
        return description.contains(regex);
    }

    /**
     * This method checks if the item is exempted from tax.
     * @param description - description of the item
     * @return true if it is present in the itemsExemptedList else false
     */
    public static boolean isItemExemptedFromTax(String description){
        String[] wordsInDescription = description.split(" ");
        for (String s : wordsInDescription) {
            if (itemsExemptedList.contains(s)) {
                return true;
            }
        }
        return false;
    }

}
