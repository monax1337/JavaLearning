package learn.bus;

public class BusManager {
    private Bus[] buses;
    private int size;

    public BusManager(int quantity) {
        this.buses = new Bus[quantity];
        this.size = 0;
    }

    public void addBus(Bus bus) {
        if (size < buses.length) {
            buses[size++] = bus;
        } else {
            System.out.println("Массив полный");
        }
    }

    public void printBusesByRouteNumber(int routeNum) {
        for (Bus bus : buses) {
            if (bus.getRouteNumber() == routeNum) {
                System.out.println(bus.toString());
            }
        }
    }

    public void printBusesByYears(int years) {
        int currentYear = java.time.Year.now().getValue();
        for (Bus bus : buses) {
            if (currentYear - bus.getStartYear() > years) {
                System.out.println(bus.toString());
            }
        }
    }

    public void printBusesByMileage(int mileage) {
        for (Bus bus : buses) {
            if (bus.getMileage() > mileage) {
                System.out.println(bus.toString());
            }
        }
    }

    public static void main(String[] args) {
        BusManager busManager = new BusManager(3);

        Bus bus1 = new Bus("Max", "asd123", 17, "Volvo", 2010, 150000);
        Bus bus2 = new Bus("Andrew", "zxc456", 2, "Mercedes", 2015, 100000);
        Bus bus3 = new Bus("Nikita", "qwe890", 33, "Volvo", 2012, 200000);

        busManager.addBus(bus1);
        busManager.addBus(bus2);
        busManager.addBus(bus3);

        System.out.println("Список автобусов для маршрута 17:");
        busManager.printBusesByRouteNumber(17);

        System.out.println("Список автобусов, которые эксплуатируются больше 10 лет:");
        busManager.printBusesByYears(10);

        System.out.println("Список автобусов, пробег у которых больше 150000 км:");
        busManager.printBusesByMileage(150000);
    }
}
