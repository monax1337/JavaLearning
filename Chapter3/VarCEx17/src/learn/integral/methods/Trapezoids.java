package learn.integral.methods;
import java.util.function.Function;

public class Trapezoids implements NumericalIntegration {
    public double integrate(Function<Double, Double> integrand, double a, double b, int n) {
        double sum = (integrand.apply(a) + integrand.apply(b)) / 2;
        double h = (b - a) / n;
        for (int i = 1; i < n; i++) {
            sum += integrand.apply(a + i * h);
        }
        return sum * h;
    }
}
