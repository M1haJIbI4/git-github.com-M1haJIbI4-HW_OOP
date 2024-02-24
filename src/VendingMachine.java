import java.util.ArrayList;
import java.util.List;


public class VendingMachine {
    private List<HotDrink> hotDrinks;

    public VendingMachine() {
        hotDrinks = new ArrayList<>();
    }

    public void addHotDrink(HotDrink hotDrink) {
        hotDrinks.add(hotDrink);
    }

    public void displayMenu() {
        for (HotDrink hotDrink : hotDrinks) {
            System.out.println(hotDrink.toString());
        }
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        HotDrink tea = new HotDrink("Чай", 70.5, 85);
        HotDrink coffee = new HotDrink("Кофе", 105.5, 90);

        vendingMachine.addHotDrink(tea);
        vendingMachine.addHotDrink(coffee);

        vendingMachine.displayMenu();
    }
}