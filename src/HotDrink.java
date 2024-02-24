// Класс HotDrink, наследник класса Product
public class HotDrink extends Product {
    private int temperature;

    public HotDrink(String name, double price, int temperature) {
        super(name, price);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Горячий напиток: " + getName() + ", Цена (руб): " + getPrice() + ", Температура (С): " + temperature;
    }
}