package learn.Line;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private double a;
    private double b;
    private double c;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getXIntercept() {
        return -c / a;
    }

    public double getYIntercept() {
        return -c / b;
    }

    public static double[] getIntersectionCoordinates(Line line1, Line line2) {
        double determinant = line1.a * line2.b - line2.a * line1.b;
        if (Math.abs(determinant) < 1e-6) {
            return null;
        } else {
            double x = (line2.c * line1.b - line1.c * line2.b) / determinant;
            double y = (line1.c * line2.a - line2.c * line1.a) / determinant;
            return new double[]{x, y};
        }
    }

    public static List<List<Line>> findParallelGroups(List<Line> lines) {
        List<List<Line>> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            Line line1 = lines.get(i);
            List<Line> parallelGroup = new ArrayList<>();
            parallelGroup.add(line1);
            for (int j = i + 1; j < lines.size(); j++) {
                Line line2 = lines.get(j);
                if (Line.areParallel(line1, line2)) {
                    parallelGroup.add(line2);
                }
            }
            if (parallelGroup.size() > 1) {
                result.add(parallelGroup);
            }
        }
        return result;
    }

    private static boolean areParallel(Line line1, Line line2) {
        return line1.a * line2.b == line2.a * line1.b;
    }
}
