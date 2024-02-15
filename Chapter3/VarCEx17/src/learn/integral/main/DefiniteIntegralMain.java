package learn.integral.main;
import learn.integral.methods.*;

import java.util.function.Function;

public class DefiniteIntegralMain {
    public static void main(String[] args) {
        Function<Double, Double> integrand = x -> x * x;

        NumericalIntegration leftRectangles = new LeftRectangles();
        NumericalIntegration rightRectangles = new RightRectangles();
        NumericalIntegration midRectangles = new MidRectangles();
        NumericalIntegration trapezoids = new Trapezoids();
        NumericalIntegration simpson = new Simpson();

        double a = 0;
        double b = 2;
        int n = 100;

        System.out.println("Left Rectangles: " + leftRectangles.integrate(integrand, a, b, n));
        System.out.println("Right Rectangles: " + rightRectangles.integrate(integrand, a, b, n));
        System.out.println("Mid Rectangles: " + midRectangles.integrate(integrand, a, b, n));
        System.out.println("Trapezoids: " + trapezoids.integrate(integrand, a, b, n));
        System.out.println("Simpson: " + simpson.integrate(integrand, a, b, n));
    }
}
