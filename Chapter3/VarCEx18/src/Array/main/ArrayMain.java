package Array.main;

import java.util.Arrays;

import Array.sorts.*;

public class ArrayMain {
    public static void main(String[] args) {
        SortInterface bubble = new BubbleSort();
        SortInterface cocktail = new CocktailSort();
        SortInterface selection = new SelectionSort();
        SortInterface insertion = new InsertionSort();

        int[] array = {5, 3, 8, 2, 1, 4};

        System.out.println("Bubble Sort: " + Arrays.toString(bubble.sort(array)));
        System.out.println("Cocktail Sort: " + Arrays.toString(cocktail.sort(array)));
        System.out.println("Selection Sort: " + Arrays.toString(selection.sort(array)));
        System.out.println("Insertion Sort: " + Arrays.toString(insertion.sort(array)));
    }
}
