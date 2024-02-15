package learn.integral.methods;
import java.util.function.Function;

public interface NumericalIntegration {
    double integrate(Function<Double, Double> integrand, double a, double b, int n);
}
