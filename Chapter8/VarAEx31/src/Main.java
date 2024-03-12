import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "This is a Sample text with Several Words Starting with Capital letters and Some without. Also, there are Words with Uppercase.";
        String regex = "\\b\\p{Upper}\\p{L}*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            count++;
        }
        System.out.println("Количество слов, начинающихся с прописной буквы: " + count);
    }
}
