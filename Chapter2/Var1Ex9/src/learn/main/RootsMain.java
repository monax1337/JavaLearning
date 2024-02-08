package learn.main;

import learn.roots.CalculateRoots;

import java.util.Scanner;

public class RootsMain {
    /*
        * assigned = "02.02.2023 12:40" completed = "07.02.2023 20:00"
        @author Kruglikovsky Maxim
        @version 1.0
    **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите коэффициенты квадратного уравнения (a, b, c):");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.close();

        if (a == 0) {
            System.out.println("Ошибка");
        } else {

            CalculateRoots calc = new CalculateRoots();
            double[] roots = calc.calculateRoots(a, b, c);
            switch (roots.length) {
                case 0 -> System.out.println("No roots");
                case 1 -> System.out.println("Root: " + roots[0]);
                default -> System.out.println("Roots: " + roots[0] + " " + roots[1]);
            }
        }
    }
}
