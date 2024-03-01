import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 1, 2, 5};
        Integer[] uniqueArray = removeDuplicates(array);
        System.out.println(Arrays.toString(uniqueArray));
    }

    public static <T> T[] removeDuplicates(T[] array){
        return Arrays.stream(array)
                .distinct()
                .toArray(size -> Arrays.copyOf(array, size));
    }
}
