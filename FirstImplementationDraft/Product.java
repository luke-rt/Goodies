package FirstImplementationDraft;

public class Product {
    /**
     * Class to represent a product type i.e. Capri Sun
     * 
     * 11/14/21
     * java8
     * @Luke and Steve
     * 
     */
    private final String name;
    private int quantity;
    private final int cost;
    private final float price;

    public Product(String name, String quantity, String cost, String price) {
        /**
         * Constructor method
         * 
         */

        this.name = name;
        this.quantity = Integer.parseInt(quantity); // quantity in stock
        this.cost = Integer.parseInt(cost); // cost per batch
        this.price = Float.parseFloat(price); // sale price per unit
    }

    public String toString() {
        return String.format("%-15s%-8d%-8d%f", this.name, this.quantity, this.cost, this.price);
    }

    public String getName() {
        /**
         * Getter method for name
         */
        return this.name;
    }

    public float getPrice() {
        /**
         * Getter method for price
         * 
         */
        return this.price;
    }

    public int getQuantity() {
        /**
         * Getter method for product type quantity
         * 
         */
        return this.quantity;
    }

    public int getCost() {
        /**
         * Getter method for the cost of the entire batch
         * 
         */
        return this.cost;
    }

    public void increaseQuantity(int val) {
        /**
         * Increase the quantity of product type
         * 
         */
        this.quantity += val;
    }

    public void decreaseQuantity(int val) {
        /**
         * Decrease quantity of product type
         * 
         */
        this.quantity -= val;
    }
}