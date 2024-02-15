package learn.Line;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static void main(String[] args) {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(2, -3, 6));
        lines.add(new Line(-4, 1, 8));
        lines.add(new Line(3, 5, -15));
        lines.add(new Line(-2, 6, -12));
        lines.add(new Line(2, -3, -10));

        for (Line line : lines) {
            System.out.println("X intercept: " + line.getXIntercept() + ", Y intercept: " + line.getYIntercept());
        }

        double[] intersection = Line.getIntersectionCoordinates(lines.get(0), lines.get(1));
        if (intersection != null) {
            System.out.println("Intersection coordinates: (" + intersection[0] + ", " + intersection[1] + ")");
        } else {
            System.out.println("Lines are parallel, no intersection.");
        }

        List<List<Line>> parallelGroups = Line.findParallelGroups(lines);
        System.out.println("Parallel groups:");
        for (List<Line> group : parallelGroups) {
            System.out.println("Group:");
            for (Line line : group) {
                System.out.println("  Line: " + line.getB() + "x + " + line.getB() + "y + " + line.getC() + " = 0");
            }
        }
    }
}
