package learn.manager;

import learn.circle.Circle;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static List<List<Circle>> findCollinearGroups(List<Circle> circles) {
        List<List<Circle>> result = new ArrayList<>();
        for (int i = 0; i < circles.size(); i++) {
            Circle circle1 = circles.get(i);
            List<Circle> collinearGroup = new ArrayList<>();
            collinearGroup.add(circle1);
            for (int j = i + 1; j < circles.size(); j++) {
                Circle circle2 = circles.get(j);
                if (areCentersCollinear(circle1, circle2)) {
                    collinearGroup.add(circle2);
                }
            }
            if (collinearGroup.size() > 1) {
                result.add(collinearGroup);
            }
        }
        return result;
    }

    private static boolean areCentersCollinear(Circle circle1, Circle circle2) {
        double center1X = circle1.getCenterX();
        double center1Y = circle1.getCenterY();
        double center2X = circle2.getCenterX();
        double center2Y = circle2.getCenterY();
        return center1X * (center1Y - center2Y) +
                center2X * (center2Y - center1Y) +
                circle2.getRadius() * (center2Y - center1Y) < 1e-6;
    }

    public static Circle findLargestByArea(List<Circle> circles) {
        Circle largestCircle = null;
        double maxArea = Double.MIN_VALUE;
        for (Circle circle : circles) {
            double area = circle.getArea();
            if (area > maxArea) {
                maxArea = area;
                largestCircle = circle;
            }
        }
        return largestCircle;
    }

    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(5.0, 0.0, 0.0));
        circles.add(new Circle(3.0, 2.0, 3.0));
        circles.add(new Circle(4.0, -1.0, 2.0));
        circles.add(new Circle(6.0, 5.0, -2.0));

        List<List<Circle>> collinearGroups = findCollinearGroups(circles);
        System.out.println("Collinear groups:");
        for (List<Circle> group : collinearGroups) {
            System.out.println("Group:");
            for (Circle circle : group) {
                System.out.println("  Radius: " + circle.getRadius() + ", Center: (" +
                        circle.getCenterX() + ", " + circle.getCenterY() + ")");
            }
        }

        Circle largestByArea = findLargestByArea(circles);
        System.out.println("Circle with largest area: " + largestByArea.getArea());
    }
}
