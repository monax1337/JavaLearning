package learn.main;

import learn.check.IsHalfSumNeighbors;

import java.util.Scanner;

public class NeighborsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for(int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        IsHalfSumNeighbors check = new IsHalfSumNeighbors();
        System.out.println(check.isHalfSumNeighbors(array));
    }
}
