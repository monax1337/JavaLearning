import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    static String VOWELS = "аеёиоуыэюя";

    public static void main(String[] args) {
        String text = "Все слова текста рассортировать в порядке убывания их длин, при этом все слова одинаковой длины рассортировать в порядке возрастания в них количества гласных букв.";
        System.out.println(sortWords(text));
    }

    private static String sortWords(String text) {
        return Arrays.stream(text.split("\\s+"))
                .sorted((w1, w2) -> {
                    int lenDiff = w2.length() - w1.length();
                    if (lenDiff != 0) {
                        return lenDiff;
                    } else {
                        return countVowels(w1) - countVowels(w2);
                    }
                })
                .collect(Collectors.joining(" "));
    }

    private static int countVowels(String word) {
        return (int) word.toLowerCase().chars()
                .filter(c -> VOWELS.indexOf(c) != -1)
                .count();
    }
}