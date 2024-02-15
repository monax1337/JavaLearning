package learn.bus;

public class Bus {
    private String surnameDriver;
    private String busNumber;
    private int routeNumber;
    private String brand;
    private int startYear;
    private int mileage;

    public Bus(String surnameDriver, String busNumber, int routeNumber, String brand, int startYear, int mileage) {
        this.surnameDriver = surnameDriver;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.brand = brand;
        this.startYear = startYear;
        this.mileage = mileage;
    }

    public String getSurnameDriver() {
        return surnameDriver;
    }

    public void setSurnameDriver(String surnameDriver) {
        this.surnameDriver = surnameDriver;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String toString() {
        return "Bus{" +
                "driverName='" + surnameDriver + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", routeNumber='" + routeNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", startYear=" + startYear +
                ", mileage=" + mileage +
                '}';
    }
}
