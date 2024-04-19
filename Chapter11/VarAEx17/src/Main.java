import java.util.List;
import java.util.ListIterator;

import static service.FillListService.fillList;
import static service.FindRangeService.findRange;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = fillList();
        ListIterator<String> start = fruits.listIterator();
        ListIterator<String> end = fruits.listIterator(fruits.size());

        List<ListIterator<String>> range = findRange(start, end, 'C');

        if (range != null) {
            System.out.println("Range of fruits starting with 'C':");
            ListIterator<String> rangeStart = range.get(0);
            ListIterator<String> rangeEnd = range.get(1);
            System.out.println("Range start: " + rangeStart.nextIndex());
            System.out.println("Range end: " + rangeEnd.nextIndex());
            while (rangeStart.hasNext() && rangeStart != rangeEnd) {
                String str = rangeStart.next();
                System.out.println(str);
            }
        } else {
            System.out.println("No strings starting with 'C' found.");
        }
    }
}
