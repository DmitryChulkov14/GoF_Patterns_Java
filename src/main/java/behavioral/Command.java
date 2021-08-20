package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Command is used to encapsulate all information needed to perform an action or trigger an event at a later time.
 * This information includes the method name, the object that owns the method and values for the method parameters.
 * <br/>
 * <br/>
 * Команда используется для инкапсуляции всей информации, необходимой для выполнения действия или инициирования события позже.
 * Эта информация включает название метода, объект, которому принадлежит метод и значения для параметров метода.
 */
public class Command {

    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}

interface Order {
    void execute();
}

class Stock {
    private final String name = "ABC";
    private final int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}

class BuyStock implements Order {
    private final Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}

class SellStock implements Order {
    private final Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}

class Broker {
    private final List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        orderList.forEach(Order::execute);
        orderList.clear();
    }
}
