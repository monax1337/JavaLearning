package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindKeyGreaterThanFiveService {
    public static List<String> findKeyGreaterThanFive(Map<Integer, String> hashMap){
        return hashMap.entrySet().stream()
                .filter(entry -> entry.getKey() > 5)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
