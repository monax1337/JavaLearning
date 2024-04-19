package service;

import java.util.Map;

public class FindMultiplyKeysService {
    public static Integer findMultiplyKeys(Map<Integer, String> hashMap) {
        return hashMap.entrySet().stream()
                .filter(entry -> entry.getValue().length() > 5)
                .mapToInt(Map.Entry::getKey)
                .reduce(1, (a, b) -> a * b);
    }
}
