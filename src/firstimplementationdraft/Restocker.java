package firstimplementationdraft;

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

        File file = new File(filename);

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
}
