package airport.services;

import airport.model.Flight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Airport {
    private Semaphore terminals;
    private Semaphore runways;
    private ExecutorService service;

    public Airport(int numTerminals, int numRunways) {
        terminals = new Semaphore(numTerminals);
        runways = new Semaphore(numRunways);
        service = Executors.newCachedThreadPool();
    }

    public void land(Flight flight) {
        service.execute(() -> {
            try {
                runways.acquire();
                System.out.println(flight + " is landing...");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(flight + " has landed.");
                terminals.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                runways.release();
            }
        });
    }

    public void takeoff(Flight flight) {
        service.execute(() -> {
            try {
                terminals.acquire();
                System.out.println(flight + " is taking off...");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(flight + " has taken off.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                terminals.release();
            }
        });
    }

    public void shutdown() {
        service.shutdown();
    }
}