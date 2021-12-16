package FirstImplementationDraft;

import java.util.Map;

public class BusinessOperations {
    Restocker restocker;

    public BusinessOperations() {
        this.restocker = new Restocker("data.txt");
    }

    public void printBusinessMenu() {
        System.out.printf("%-12s%-10s%-8s%-1s\n", "Name", "Quantity", "Cost", "Sale Price");
        for(Map.Entry<String, Product> entry : this.restocker.stock.entrySet()) {
            System.out.printf("%-15s%-8d%-8d%f\n", entry.getKey(), entry.getValue().getQuantity(), entry.getValue().getCost(), entry.getValue().getPrice());
        }
    }

    public void printCustomerMenu() {
        System.out.printf("%-14s%s\n", "Name", "Sale Price");
        for(Map.Entry<String, Product> entry : this.restocker.stock.entrySet()) {
            System.out.printf("%-15s%f\n", entry.getKey(), entry.getValue().getPrice());
        }
    }
    
}
