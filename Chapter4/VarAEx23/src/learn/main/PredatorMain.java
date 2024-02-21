package learn.main;

import learn.animal.predator.Predator;
import learn.organs.claws.Claws;
import learn.organs.teeth.Teeth;

public class PredatorMain {
    public static void main(String[] args) {
        Claws lionClaws = new Claws(5);
        Teeth lionTeeth = new Teeth(40);
        Predator lion = new Predator(lionClaws, lionTeeth);
        Claws tigerClaws = new Claws(5);
        Teeth tigerTeeth = new Teeth(10);
        Predator tiger = new Predator(tigerClaws, tigerTeeth);
        System.out.println("Equals: " + lion.equals(tiger));
        System.out.println("HashCode: " + lion.hashCode());
        System.out.println("ToString: " + lion.toString());
        lion.roar();
        tiger.roar();
    }
}
