package exchange.service;

import exchange.exchangeindex.ExchangeIndex;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExchangeIndexService {
    private static final int MIN_INDEX = 50;
    private static final int INDEX_CHANGE_LIMIT = 5;

    private final ExchangeIndex exchangeIndex;
    private final Lock indexLock;

    public ExchangeIndexService(ExchangeIndex exchangeIndex) {
        this.exchangeIndex = exchangeIndex;
        this.indexLock = new ReentrantLock();
    }

    public void updateExchangeIndex(int change) {
        indexLock.lock();
        try {
            int currentIndex = exchangeIndex.getIndex();
            int newIndex = currentIndex + change;

            if (newIndex < MIN_INDEX) {
                suspendTrading();
            } else if (Math.abs(change) > INDEX_CHANGE_LIMIT) {
                change = Integer.signum(change) * INDEX_CHANGE_LIMIT;
                newIndex = currentIndex + change;
            }

            exchangeIndex.updateIndex(change);
            System.out.println("Индекс биржи изменился на " + change + " пунктов. Текущий индекс: " + newIndex);
        } finally {
            indexLock.unlock();
        }
    }

    private void suspendTrading() {
        System.out.println("Торги приостановлены из-за резкого падения индекса биржи.");
    }
}