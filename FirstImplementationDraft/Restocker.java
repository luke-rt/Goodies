package FirstImplementationDraft;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Restocker {
    public Map<String, Product> stock;

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
}
