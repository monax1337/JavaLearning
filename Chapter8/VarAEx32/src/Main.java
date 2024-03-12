import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "This is a sample text with some occurrences of the word \\\"text\\\". Text can occur multiple times.";
        String wordToFind = "text";
        String regex = "\\b" + wordToFind + "\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("Количество вхождений слова \"" + wordToFind + "\": " + count);
    }
}
