package learn.main;

import learn.check.IsPalindrome;

import java.util.Scanner;

public class PalindromeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Введите числа:");
        for(int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        IsPalindrome check = new IsPalindrome();

        System.out.println("Числа-палиндромы:");
        for(int number : numbers) {
            if(check.isPalindrome(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
