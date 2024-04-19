package service;

import java.util.*;

public class FindRangeService {
    public static List<ListIterator<String>> findRange(ListIterator<String> start, ListIterator<String> end, char symbol) {
        ListIterator<String> rangeStart = null;
        ListIterator<String> rangeEnd = null;

        while (start.hasNext()) {
            String str = start.next();
            System.out.println("Checking string 1: " + str);
            if (str.charAt(0) == symbol) {
                rangeStart = start;
                rangeStart.previous();
                System.out.println(rangeStart.nextIndex());
                break;
            }
        }

        if (rangeStart == null) {
            return null;
        }

        while (rangeStart.hasNext() && rangeStart != end) {
            String str = rangeStart.next();
            System.out.println("Checking string: " + str);
            if (str.charAt(0) != symbol) {
                rangeEnd = rangeStart;
                rangeEnd.previous();
                break;
            }
        }

        if (rangeEnd == null) {
            rangeEnd = end;
            rangeEnd.previous();
        }

        return new ArrayList<>(Arrays.asList(rangeStart, rangeEnd));
    }
}