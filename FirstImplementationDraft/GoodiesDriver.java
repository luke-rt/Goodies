package FirstImplementationDraft;

public class GoodiesDriver {
    public static void main(String[] args) {
        Restocker restocker = new Restocker("data.txt");
        restocker.printBusinessMenu();
        restocker.printCustomerMenu();
    }
}
