package airport.terminal;

import airport.model.Passenger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Terminal {
    private Semaphore access;

    public Terminal(int capacity) {
        access = new Semaphore(capacity);
    }

    public void processPassenger(Passenger passenger) {
        try {
            access.acquire();
            System.out.println(passenger + " is being processed at the terminal...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(passenger + " has been processed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            access.release();
        }
    }
}
