package learn.animal.predator;

import learn.organs.claws.Claws;
import learn.organs.teeth.Teeth;

import java.util.Objects;

public class Predator {
    private Claws claws;
    private Teeth teeth;

    public Predator(Claws claws, Teeth teeth) {
        this.claws = claws;
        this.teeth = teeth;
    }

    public void roar() {
        if (teeth.getSharpness() >= 20) {
            System.out.println("ROAR! Predator has strong teeth.");
        } else {
            System.out.println("Predator's teeth are not strong enough to roar effectively.");
        }
    }

    public void run() {
        System.out.println("Predator is running!");
    }

    public void sleep() {
        System.out.println("Predator is sleeping.");
    }

    public void hunt() {
        System.out.println("Predator is hunting!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Predator predator = (Predator) o;
        return Objects.equals(claws, predator.claws) &&
                Objects.equals(teeth, predator.teeth);
    }

    @Override
    public int hashCode(){
        return Objects.hash(claws, teeth);
    }

    @Override
    public String toString() {
        return "Predator{" +
                "claws=" + claws +
                ", teeth=" + teeth +
                '}';
    }
}
