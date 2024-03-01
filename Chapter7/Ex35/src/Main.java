import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] fruits = {"banana", "apple", "orange", "grape", "kiwi"};
        int num = 4;
        String[] filteredFruits = Arrays.stream(fruits)
                .filter(s -> s.length() > num)
                .toArray(String[]::new);

        for (String fruit : filteredFruits){
            System.out.println(fruit);
        }
    }
}
