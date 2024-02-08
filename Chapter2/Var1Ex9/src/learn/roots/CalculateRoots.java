package learn.roots;

public class CalculateRoots {
    public double[] calculateRoots(double a, double b, double c) {
        /*
            @return boolean[]
            @param double a, double b, double c
        **/
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[] {root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[] {root};
        } else {
            return new double[0];
        }
    }
}
