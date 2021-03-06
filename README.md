# BillGenerator - Generates bill along with Sales Tax calculations

## Problem 1: SALES TAXES
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items,
and the total amounts of sales taxes paid.  The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...

### Use Case Example 1
#### INPUT:
> 1 book at 12.49  
> 1 music CD at 14.99  
> 1 chocolate bar at 0.85
#### OUTPUT:
> 1 book: 12.49  
> 1 music CD: 16.49  
> 1 chocolate bar: 0.85  
> Sales Taxes: 1.50  
> Total: 29.83  


### Use Case Example 2
#### INPUT:
> 1 imported box of chocolates at 10.00  
> 1 imported bottle of perfume at 47.50  
#### OUTPUT:
> 1 imported box of chocolates: 10.50  
> 1 imported bottle of perfume: 54.65  
> Sales Taxes: 7.65  
> Total: 65.15


### Use Case Example 3
#### INPUT:
> 1 imported bottle of perfume at 27.99  
> 1 bottle of perfume at 18.99  
> 1 packet of headache pills at 9.75  
> 1 box of imported chocolates at 11.25
#### OUTPUT:
> 1 imported bottle of perfume: 32.19  
> 1 bottle of perfume: 20.89  
> 1 packet of headache pills: 9.75  
> 1 imported box of chocolates: 11.85  
> Sales Taxes: 6.70  
> Total: 74.68

### Run The Project
#### Step 1
To build the project issue this command. This will generate the executable
> mvn clean install


#### Step 2
To execute the project
>java -jar target/BillGenerator-1.0-SNAPSHOT.jar 

#### Step 3
You should see output similar to this

>Please enter item details / type 'quit' to exit </br>
>Format: <quantity> <imported(optional)> <description> at <price> </br>
>Ex: '1 imported box of chocolates at 10.00' </br>
>Please type 'done' to stop adding new items and print bill with sales tax! </br>

Please enter items similar to this. Please note that each item should be entered in a seperate line as shown below. After you are done adding please type 'done'.
>1 book at 12.49 </br>
>1 music CD at 14.99 </br>
>1 chocolate bar at 0.85 </br>
>done </br>

#### Step 4
Now you will see bill details as shown below

> --------------- Final Bill ---------------- </br>
>1 book: 12.49 </br>
>1 music CD: 16.49 </br>
>1 chocolate bar: 0.85 </br>
>Sales Taxes :1.50 </br>
>Total: 29.83 </br>
> ------------------------------------------- </br>







