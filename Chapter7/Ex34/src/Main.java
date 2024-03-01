import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Double> supplier = () -> Double.valueOf(Math.PI);

        System.out.println(supplier.get());
    }
}
