package exchange.service;

import exchange.config.AppConfig;
import exchange.exchangeindex.ExchangeIndex;
import exchange.stock.Stock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StockExchangeService {
    private final Map<String, Stock> stocks;
    private final Lock stockLock;
    private final ExchangeIndex exchangeIndex;

    public StockExchangeService() {
        this.stocks = new ConcurrentHashMap<>();
        this.stockLock = new ReentrantLock();
        this.exchangeIndex = new ExchangeIndex();
        initializeStocks();
    }

    private void initializeStocks() {
        for (int i = 1; i <= AppConfig.NUM_STOCKS; i++) {
            stocks.put("Stock" + i, new Stock("Stock" + i, 100, 1000));
        }
    }

    public ExchangeIndex getExchangeIndex() {
        return exchangeIndex;
    }

    public Stock getStock(String name) {
        stockLock.lock();
        try {
            return stocks.get(name);
        } finally {
            stockLock.unlock();
        }
    }

    public void updateStockPrice(Stock stock, int change) {
        stockLock.lock();
        try {
            int currentPrice = stock.getPrice();
            int newPrice = currentPrice + change;
            stock.setPrice(newPrice);
            System.out.println("Цена акции " + stock.getName() + " изменилась на " + change + ". Новая цена: " + newPrice);
        } finally {
            stockLock.unlock();
        }
    }
}