package service;

import java.util.Map;

public class FindKeyZeroService {
    public static String findKeyZeroService(Map<Integer, String> hashMap){
        return hashMap.entrySet().stream()
                .filter(entry -> entry.getKey() == 0)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("");
    }
}
