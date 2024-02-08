package learn.main;

import learn.find.MonthNumber;

import java.util.Scanner;

public class MonthMain {
    public static void main(String[] args) {
        int monthNumber = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите число от 1 до 12: ");
                monthNumber = Integer.parseInt(scanner.nextLine());

                if (monthNumber >= 1 && monthNumber <= 12) {
                    break;
                } else {
                    System.out.println("Число должно быть от 1 до 12");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не число");
            }
        }
        scanner.close();
        MonthNumber month = new MonthNumber();
        System.out.println(month.findMonthByNumber(monthNumber));
    }
}
