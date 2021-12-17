package FirstImplementationDraft;

import java.util.Scanner;

public class BusinessOperations {
    Scanner scanner;
    Restocker restocker;

    public BusinessOperations() {
        this.scanner = new Scanner(System.in);
        this.restocker = new Restocker("data.txt");
    }

    public void prompt() {
        System.out.println("""

        Welcome to Goodies
            1. Use as Customer
            2. Use as Business Manager
            3. Exit
        """);

        int option = this.scanner.nextInt();

        switch(option) {
            case 1:
                handleCustomerRes();
                break;
            case 2:
                handleBusinessRes();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid response");
                break;
        }
    }

    private void handleCustomerRes() {
        boolean cont = true;
        int total = 0;
        while(cont) {
            printCustomerMenu();
            System.out.println("""

            What would you like to do?
                1. Purchase
                2. Proceed to checkout
                3. Exit
            """);

            int res = this.scanner.nextInt();
            switch(res) {
                case 1:
                    System.out.println("What would you like to buy? Type the index number of your item:");
                    int item = this.scanner.nextInt();
                    System.out.println("How many would you like to purchase?");
                    int quantity = this.scanner.nextInt();

                    System.out.println("Purchasing " + quantity + " units of " + this.restocker.stock.get(item).getName());
                    System.out.println("This will add " + quantity * this.restocker.stock.get(item).getPrice() + " to your total");
                    total += quantity * this.restocker.stock.get(item).getPrice();
                    // remove quantity from price of this.restocker.stock.get(item)
                    break;
                case 2:
                    System.out.println("Proceeding to checkout");
                    System.out.println("Your total is $" + total);
                    
                    cont = false;
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid response");
                    break;
            }
        }
    }

    private void handleBusinessRes() {
        printBusinessMenu();

    }


    private void printBusinessMenu() {
        System.out.printf("%-12s%-10s%-8s%-1s\n", "Name", "Quantity", "Cost", "Sale Price");
        for(int i = 0; i < this.restocker.stock.size(); i++) {
            System.out.println(i + ". " + this.restocker.stock.get(i));
        }
    }

    private void printCustomerMenu() {
        System.out.printf("%-14s%s\n", "Name", "Sale Price");
        for(int i = 0; i < this.restocker.stock.size(); i++) {
            System.out.printf(i + ". %-15s%f\n", this.restocker.stock.get(i).getName(), this.restocker.stock.get(i).getPrice());
        }
    }
    
}
