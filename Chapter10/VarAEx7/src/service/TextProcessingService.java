package service;

import java.util.ArrayList;
import java.util.List;

public class TextProcessingService {
    public static String processLine(String line) {
        List<String> words = new ArrayList<>();
        for (String word : line.split("\\s+")){
            words.add(word.substring(0, 1).toUpperCase() + word.substring(1));
        }
        return String.join(" ", words);
    }
}
