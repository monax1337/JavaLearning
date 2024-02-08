package learn.main;

import learn.check.FindPalindromeList;

import java.util.Scanner;

public class PalindromeMain {
    /*
    * assigned = "02.02.2023 12:40" completed = "07.02.2023 20:00"
    @author Kruglikovsky Maxim
    @version 1.0
     **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Введите числа: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        FindPalindromeList palindromeList = new FindPalindromeList();
        switch (palindromeList.findPalindromeList(numbers).length) {
            case 0 -> System.out.println("0");
            case 1 -> System.out.println(palindromeList.findPalindromeList(numbers)[0]);
            default -> System.out.println(palindromeList.findPalindromeList(numbers)[1]);
        }
    }
}
