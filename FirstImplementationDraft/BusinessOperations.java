
package FirstImplementationDraft;

import java.util.Scanner;

public class BusinessOperations {
    /**
     * BusinessOperations.java
     * handles user input and interactions with customer
     * 
     * @Luke T Steve X JP K
     * 12/17/21
     * java8
     */
    Scanner scanner;     
    Restocker restocker;

    public BusinessOperations() {
        this.scanner = new Scanner(System.in);  //initializing scanner
        this.restocker = new Restocker("data.txt");  //initialzing Restocker class to write to data.txt file
    }

    public void prompt() {       
        /**
         * printing out how the user will interact with the program
         * 
         */
        System.out.println(""" 

        Welcome to Goodies
            1. Use as Customer
            2. Use as Business Manager
            3. Exit
        """);

        int option = this.scanner.nextInt();    //saving user response as int option

        switch(option) {       //if the response == 1 or 2 then run HandCustomerRes which will print more specific options
            case 1:
                handleCustomerRes();  
                break;
            case 2:
                handleBusinessRes();
                break;
            case 3:
                System.exit(0);          //if the response == 3 then exit the program
            default:
                System.out.println("Invalid response");    //handling if user doesnt respond with 1, 2, or 3
                break;
        }
    }

    private void handleCustomerRes() {
        /**
         * method that will get the the item, quantity, and price from the user
         *
         */
        boolean cont = true;
        int total = 0;  // total cost of transaction
        while(cont) {
            printCustomerMenu();
            System.out.println("""

            What would you like to do?
                1. Purchase
                2. Proceed to checkout
                3. Exit
            """);

            int res = this.scanner.nextInt();
            switch(res) {     //if user responds with 1, go through steps of buying an item, and then get price and quantity
                case 1:
                    System.out.println("What would you like to buy? Type the index number of your item:");
                    int item = this.scanner.nextInt();
                    System.out.println("How many would you like to purchase?");
                    int quantity = this.scanner.nextInt();

                    System.out.println("Purchasing " + quantity + " units of " + this.restocker.inventory.get(item).getName());
                    System.out.println("This will add " + quantity * this.restocker.inventory.get(item).getPrice() + " to your total");
                    total += quantity * this.restocker.inventory.get(item).getPrice();
                    // remove quantity from price of this.restocker.stock.get(item)
                    break;
                case 2:        // if user responds with 2, the transaction is over --> proceed to checkout
                    System.out.println("Proceeding to checkout");
                    System.out.println("Your total is $" + total);
                    
                    cont = false;
                    break;
                case 3:       // if user responds with 3 then exit
                    System.exit(0);
                default:
                    System.out.println("Invalid response");  
                    break;
            }
        }
    }

    private void handleBusinessRes() {
        /**
         * handles manger interactions
         * 
         */
        printBusinessMenu();

    }


    private void printBusinessMenu() {   
        /**
         * prints formatted manager options
         * 
         */
        System.out.printf("%-12s%-10s%-8s%-1s\n", "Name", "Quantity", "Cost", "Sale Price");
        for(int i = 0; i < this.restocker.inventory.size(); i++) {
            System.out.println(i + ". " + this.restocker.inventory.get(i));
        }
    }

    private void printCustomerMenu() {  
        /**
         * prints formatted costomer options
         * 
         */
        System.out.printf("%-14s%s\n", "Name", "Sale Price");
        for(int i = 0; i < this.restocker.inventory.size(); i++) {
            System.out.printf(i + ". %-15s%f\n", this.restocker.inventory.get(i).getName(), this.restocker.inventory.get(i).getPrice());
        }
    }
}
