import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Александр", "Мария", "Иван", "Елена", "Дмитрий"};
        System.out.println(Arrays.stream(names)
                .filter((Predicate<String>) s -> s.charAt(0) == 'А')
                .collect(Collectors.toList()));
    }
}

