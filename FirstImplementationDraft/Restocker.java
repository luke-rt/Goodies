package FirstImplementationDraft;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Restocker {
    public ArrayList<Product> stock;

    public Restocker(String filename) {
        this.stock = new ArrayList<Product>();

        File file = new File("./FirstImplementationDraft/" + filename);

        try {
            Scanner scanner = new Scanner(file);
 
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\,");

                this.stock.add(new Product(line[0], line[1], line[2], line[3]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
