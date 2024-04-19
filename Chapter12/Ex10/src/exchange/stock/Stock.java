package exchange.stock;

import java.util.concurrent.atomic.AtomicInteger;

public class Stock {
    private final String name;
    private final AtomicInteger price;
    private final AtomicInteger quantity;

    public Stock(String name, int initialPrice, int initialQuantity) {
        this.name = name;
        this.price = new AtomicInteger(initialPrice);
        this.quantity = new AtomicInteger(initialQuantity);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int newPrice) {
        price.set(newPrice);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public AtomicInteger getQuantityAtomic() {
        return quantity;
    }
}