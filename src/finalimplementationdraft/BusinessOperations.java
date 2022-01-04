package finalimplementationdraft;

import java.util.Scanner;

public class BusinessOperations {
    /**
     * BusinessOperations.java
     * handles user input and interactions with customer
     * 
     * @Luke T Steve X JP K
     *       12/17/21
     *       java8
     */
    Scanner scanner;
    Restocker restocker;

    public BusinessOperations() {
        this.scanner = new Scanner(System.in); // initializing scanner
        this.restocker = new Restocker("data.txt"); // initialzing Restocker class to write to data.txt file
    }

    public void prompt() {
        /**
         * printing out how the user will interact with the program
         * 
         */
        System.out.println("Welcome to Goodies"
                    + "\n\t1. Use as Customer"
                    + "\n\t2. Use as Business Manager"
                    + "\n\t3. Exit"
                );

        int option = this.scanner.nextInt(); // saving user response as int option

        switch (option) { // if the response == 1 or 2 then run HandCustomerRes which will print more
                          // specific options
            case 1:
                handleCustomerRes();
                break;
            case 2:
                handleBusinessRes();
                break;
            case 3:
                System.out.println("Program shutting down...");
                System.exit(0); // if the response == 3 then exit the program
            default:
                System.out.println("Invalid response"); // handling if user doesnt respond with 1, 2, or 3
                break;
        }
    }

    private void handleCustomerRes() {
        /**
         * method that will get the the item, quantity, and price from the user
         *
         */
        boolean cont = true;
        double total = 0; // total cost of transaction
        while (cont) {
            printCustomerMenu();
            System.out.println("What would you like to do?"
                        + "\n\t1. Purchase"
                        + "\n\t2. Proceed to checkout"
                        + "\n\t3. Exit"
                    );

            int res = this.scanner.nextInt();
            switch (res) { // if user responds with 1, go through steps of buying an item, and then get
                           // price and quantity
                case 1:
                    System.out.println("What would you like to buy? Type the index number of your item:");
                    int item = this.scanner.nextInt();
                    System.out.println("How many would you like to purchase?");
                    int quantity = this.scanner.nextInt();

                    System.out.println(
                            "Purchasing " + quantity + " units of " + this.restocker.inventory.get(item).getName());
                    System.out.println("This will add " + quantity * this.restocker.inventory.get(item).getPrice()
                            + " to your total");

                    total += quantity * this.restocker.inventory.get(item).getPrice();
                    // remove quantity from price of
                    this.restocker.decreaseStock(item, quantity);
                    break;
                case 2: // if user responds with 2, the transaction is over --> proceed to checkout
                    System.out.println("Proceeding to checkout");
                    System.out.println("Your total is $" + total);

                    prompt();
                    break;
                case 3: // if user responds with 3 then return to main menu
                    prompt();
                    break;
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
        boolean cont = true;
        while (cont) {
            System.out.println("What would you like to do?"
                + "\n\t1. Increase quantity"
                + "\n\t2. Decrease quantity"
                + "\n\t3. Inventory"
                + "\n\t4. Exit"
                );

            int res = this.scanner.nextInt();
            int item, quantity;
            switch (res) {
                case 1:
                    System.out.println(
                            "What item do you want to increase the quantity of? Type the index number of your item: ");
                    item = this.scanner.nextInt();
                    System.out.println(
                            "How much do you want to increase the quantity by? Type the index number of your item: ");
                    quantity = this.scanner.nextInt();

                    System.out.println("Adding " + quantity + "units of " + this.restocker.inventory.get(item).getName()
                            + "to the inventory");
                    this.restocker.increaseStock(item, quantity); // increase stock of product by amount "quantity"
                    break;
                case 2:
                    System.out.println(
                            "What item do you want to decrease the quantity of? Type the index number of your item: ");
                    item = this.scanner.nextInt();
                    System.out.println(
                            "How much do you want to decrease the quantity by? Type the index number of your item: ");
                    quantity = this.scanner.nextInt();

                    System.out.println("Removing: " + quantity + "units of "
                            + this.restocker.inventory.get(item).getName() + "to the inventory");
                    this.restocker.decreaseStock(item, quantity); // decrease stock of product by amount "quantity"
                    break;
                case 3: // if user responds with 3 then display inventory
                    System.out.println("Displaying Inventory...");
                    printBusinessMenu();
                    break;
                case 4: // if user responds with 4 then exit
                    prompt();
                    break;
                default:
                    System.out.println("Invalid response");
                    break;
            }
        }
    }

    private void printBusinessMenu() {
        /**
         * prints formatted manager options
         * 
         */
        System.out.printf("%-12s%-10s%-8s%-1s\n", "Name", "Quantity", "Cost", "Sale Price");
        for (int i = 0; i < this.restocker.inventory.size(); i++) {
            System.out.println(i + ". " + this.restocker.inventory.get(i));
        }
    }

    private void printCustomerMenu() {
        /**
         * prints formatted costomer options
         * 
         */
        System.out.printf("%-14s%s\n", "Name", "Sale Price");
        for (int i = 0; i < this.restocker.inventory.size(); i++) {
            System.out.printf(i + ". %-15s%-5.2f\n", this.restocker.inventory.get(i).getName(),
                    this.restocker.inventory.get(i).getPrice());
        }
    }
}
