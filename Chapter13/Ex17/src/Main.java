import quadrilateral.model.Quadrilateral;
import quadrilateral.service.ParallelogramsService;
import quadrilateral.service.TrapezoidsService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Параллелограммы:");
        List<Quadrilateral> parallelograms = ParallelogramsService.processParallelograms();
        for (Quadrilateral quad : parallelograms) {
            System.out.println(quad);
        }
        List<Quadrilateral> trapezoids = TrapezoidsService.processTrapezoids();
        System.out.println("\nТрапеции:");
        for (Quadrilateral quad : trapezoids) {
            System.out.println(quad);
        }
    }
}
