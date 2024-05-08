import java.util.List;
import java.util.ListIterator;

import static service.FillListService.fillList;
import static service.FindRangeService.findRange;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = fillList();
        ListIterator<String> start = fruits.listIterator();
        ListIterator<String> end = fruits.listIterator(fruits.size());

        List<Integer> range = findRange(start, end, 'C');

        if (range != null) {
            System.out.println("Range of fruits starting with 'C':");
            int rangeStart = range.get(0);
            int rangeEnd = range.get(1);
            for (int i = rangeStart; i <= rangeEnd; i++) {
                System.out.println(fruits.get(i));
            }
        } else {
            System.out.println("No strings starting with 'C' found.");
        }
    }
}
