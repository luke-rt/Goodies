package FinalImplementationDraft;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Restocker {
    /**
     * Restocker.java
     * Class to handle restocking and the inventory
     * 
     * 12/17/21
     * java8
     * 
     * @Luke T Steve X JP K
     * 
     */
    public ArrayList<Product> inventory;

    public Restocker(String filename) {
        /**
         * Constructor method that creates a stock
         * 
         */
        this.inventory = new ArrayList<Product>();

        File file = new File("./FirstImplementationDraft/" + filename);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\,");

                this.inventory.add(new Product(line[0], line[1], line[2], line[3]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void increaseStock(int index, int amount) {
        Product product = this.inventory.get(index);
        product.increaseQuantity(amount);
    }

    public void decreaseStock(int index, int amount) {
        Product product = this.inventory.get(index);
        if (product.getQuantity() - amount < 0) {
            product.decreaseQuantity(product.getQuantity()); // completely remove everything
        } else {
            product.decreaseQuantity(amount); // remove by amount
        }
        
        WriteTotTxtFile.WriteToFile()
    }
    
    private String arrayToString(){
        String ans = "";
        
    }
    
}
