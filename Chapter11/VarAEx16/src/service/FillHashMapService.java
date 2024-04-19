package service;

import java.util.HashMap;
import java.util.Map;

public class FillHashMapService {
    public static Map<Integer, String> fillHashMap() {
        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(0, "Zero");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");
        hashMap.put(6, "Six");
        hashMap.put(7, "Seven");
        hashMap.put(8, "Eight");
        hashMap.put(9, "Nine");

        return hashMap;
    }
}
