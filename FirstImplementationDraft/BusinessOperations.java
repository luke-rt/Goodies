package FirstImplementationDraft;

import java.util.Scanner;
import java.util.Map;

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
        printCustomerMenu();
    }

    private void handleBusinessRes() {
        printBusinessMenu();
    }


    private void printBusinessMenu() {
        System.out.printf("%-12s%-10s%-8s%-1s\n", "Name", "Quantity", "Cost", "Sale Price");
        for(Map.Entry<String, Product> entry : this.restocker.stock.entrySet()) {
            System.out.printf("%-15s%-8d%-8d%f\n", entry.getKey(), entry.getValue().getQuantity(), entry.getValue().getCost(), entry.getValue().getPrice());
        }
    }

    private void printCustomerMenu() {
        System.out.printf("%-14s%s\n", "Name", "Sale Price");
        for(Map.Entry<String, Product> entry : this.restocker.stock.entrySet()) {
            System.out.printf("%-15s%f\n", entry.getKey(), entry.getValue().getPrice());
        }
    }
    
}
