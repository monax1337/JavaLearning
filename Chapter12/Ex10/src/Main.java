import exchange.config.AppConfig;
import exchange.exchangeindex.ExchangeIndex;
import exchange.service.BrokerService;
import exchange.service.ExchangeIndexService;
import exchange.service.StockExchangeService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        StockExchangeService exchangeService = new StockExchangeService();
        ExchangeIndex exchangeIndex = exchangeService.getExchangeIndex();
        ExchangeIndexService indexService = new ExchangeIndexService(exchangeIndex);

        ExecutorService executor = Executors.newFixedThreadPool(AppConfig.NUM_BROKERS);
        for (int i = 1; i <= AppConfig.NUM_BROKERS; i++) {
            executor.submit(new BrokerService("Брокер " + i, exchangeService, indexService));
        }

        executor.shutdown();
    }
}