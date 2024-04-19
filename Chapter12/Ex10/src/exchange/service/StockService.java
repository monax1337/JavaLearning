package exchange.service;

import exchange.stock.Stock;

import java.util.concurrent.Semaphore;

public class StockService {

    private final Semaphore stockSemaphore = new Semaphore(1);

    public void buyShares(Stock stock, int amount) throws InterruptedException {
        stockSemaphore.acquire();
        try {
            int currentPrice = stock.getPrice();
            int currentQuantity = stock.getQuantity();
            if (currentQuantity >= amount) {
                stock.getQuantityAtomic().addAndGet(-amount);
                stock.setPrice(currentPrice + (int) Math.ceil(amount * 0.01));
                System.out.println("Куплено " + amount + " акций " + stock.getName() + " по $" + currentPrice + " за акцию.");
            } else {
                System.out.println("Попытка купить " + amount + " акций " + stock.getName() + ", но доступно только " + currentQuantity + " акций.");
            }
        } finally {
            stockSemaphore.release();
        }
    }

    public void sellShares(Stock stock, int amount) throws InterruptedException {
        stockSemaphore.acquire();
        try {
            int currentPrice = stock.getPrice();
            int currentQuantity = stock.getQuantity();
            if (currentQuantity >= amount) {
                stock.getQuantityAtomic().addAndGet(-amount);
                stock.setPrice(currentPrice - (int) Math.ceil(amount * 0.01));
                System.out.println("Продано " + amount + " акций " + stock.getName() + " по $" + currentPrice + " за акцию.");
            } else {
                System.out.println("Попытка продать " + amount + " акций " + stock.getName() + ", но имеется только " + currentQuantity + " акций.");
            }
        } finally {
            stockSemaphore.release();
        }
    }
}