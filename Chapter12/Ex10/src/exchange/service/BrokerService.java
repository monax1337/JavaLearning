package exchange.service;

import exchange.config.AppConfig;
import exchange.stock.Stock;
import java.util.Random;

public class BrokerService implements Runnable {
    private final String name;
    private final StockExchangeService exchangeService;
    private final ExchangeIndexService indexService;
    private final StockService stockService;

    public BrokerService(String name, StockExchangeService exchangeService, ExchangeIndexService indexService) {
        this.name = name;
        this.exchangeService = exchangeService;
        this.indexService = indexService;
        this.stockService = new StockService();
    }

    @Override
    public void run() {
        System.out.println("Поток " + name + " запущен");
        while (!Thread.interrupted()) {
            try {
                tradeShares();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(AppConfig.TRADING_INTERVAL * 1000);
            } catch (InterruptedException e) {
                System.out.println("Поток " + name + " был прерван");
                return;
            }
        }
    }

    private void tradeShares() throws InterruptedException {
        String stockToTrade = "Stock" + (new Random().nextInt(AppConfig.NUM_STOCKS) + 1);
        int quantity = new Random().nextInt(101);
        int action = new Random().nextInt(2);

        Stock stock = exchangeService.getStock(stockToTrade);
        if (action == 0) {
            stockService.buyShares(stock, quantity);
        } else {
            stockService.sellShares(stock, quantity);
        }

        int change = new Random().nextInt(11) - 5;
        exchangeService.updateStockPrice(stock, change);
        indexService.updateExchangeIndex(change);
    }
}