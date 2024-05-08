package service;

import java.util.*;

public class FindRangeService {
    public static List<Integer> findRange(ListIterator<String> start, ListIterator<String> end, char symbol) {
        int rangeStart = -1;
        int rangeEnd = -1;
        int index = 0;

        while (start.hasNext()) {
            String str = start.next();
            if (str.charAt(0) == symbol) {
                rangeStart = index;
                break;
            }
            index++;
        }

        if (rangeStart == -1) {
            return null;
        }

        while (start.hasNext() && start != end) {
            String str = start.next();
            if (str.charAt(0) != symbol) {
                rangeEnd = index;
                break;
            }
            index++;
        }

        if (rangeEnd == -1) {
            rangeEnd = index;
        }

        List<Integer> range = new ArrayList<>();
        range.add(rangeStart);
        range.add(rangeEnd);
        return range;
    }
}