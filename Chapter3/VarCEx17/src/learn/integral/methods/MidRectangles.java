package learn.integral.methods;
import java.util.function.Function;

public class MidRectangles implements NumericalIntegration {
    public double integrate(Function<Double, Double> integrand, double a, double b, int n) {
        double sum = 0;
        double h = (b - a) / n;
        for (int i = 0; i < n; i++) {
            sum += integrand.apply(a + (i + 0.5) * h);
        }
        return sum * h;
    }
}
