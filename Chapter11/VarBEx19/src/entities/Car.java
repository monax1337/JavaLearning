package entities;

public class Car {
    private double position;
    private double speed;

    public Car(double position, double speed){
        this.position = position;
        this.speed = speed;
    }

    public double getPosition() {
        return position;
    }

    public double getSpeed() {
        return speed;
    }
}