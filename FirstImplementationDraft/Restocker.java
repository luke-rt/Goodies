package FirstImplementationDraft;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Restocker {
    private Map<String, Product> stock;

    public Restocker(String filename) {
        this.stock = new HashMap<String, Product>();

        File file = new File("./FirstImplementationDraft/" + filename);
        try {
            Scanner scanner = new Scanner(file);
 
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\,");

                this.stock.put(line[0], new Product(line[1], line[2], line[3]));

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printBusinessMenu() {
        System.out.printf("%-12s%-10s%-8s%-1s\n", "Name", "Quantity", "Cost", "Sale Price");
        for(Map.Entry<String, Product> entry : this.stock.entrySet()) {
            System.out.printf("%-15s%-8d%-8d%f\n", entry.getKey(), entry.getValue().getQuantity(), entry.getValue().getCost(), entry.getValue().getPrice());
        }
    }

    public void printCustomerMenu() {
        System.out.printf("%-14s%s\n", "Name", "Sale Price");
        for(Map.Entry<String, Product> entry : this.stock.entrySet()) {
            System.out.printf("%-15s%f\n", entry.getKey(), entry.getValue().getPrice());
        }
    }
}
