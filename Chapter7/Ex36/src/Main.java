import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] fruits = {"banana", "apple", "orange", "grape"};
        char ch = 'o';
        int num = 6;
        System.out.println(Arrays.stream(fruits)
                .filter(s -> s.startsWith(String.valueOf(ch)) && s.length() == num)
                .collect(Collectors.toList()));
    }
}
