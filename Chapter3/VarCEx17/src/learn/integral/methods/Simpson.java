package learn.integral.methods;
import java.util.function.Function;

public class Simpson implements NumericalIntegration {
    public double integrate(Function<Double, Double> integrand, double a, double b, int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("Number of intervals must be even for Simpson's rule");
        }
        double sum = integrand.apply(a) + integrand.apply(b);
        double h = (b - a) / n;
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += 2 * integrand.apply(x);
            i++;
            if (i < n) {
                sum += 4 * integrand.apply(a + i * h);
            }
        }
        return sum * h / 3;
    }
}