package exchange.exchangeindex;

import java.util.concurrent.atomic.AtomicInteger;

public class ExchangeIndex {
    private final AtomicInteger index;

    public ExchangeIndex() {
        this.index = new AtomicInteger(100);
    }

    public int getIndex() {
        return index.get();
    }

    public void updateIndex(int change) {
        index.addAndGet(change);
    }
}