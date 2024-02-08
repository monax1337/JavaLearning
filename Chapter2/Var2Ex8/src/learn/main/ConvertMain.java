package learn.main;
import learn.convert.Convert;

import java.util.Scanner;
public class ConvertMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        String number = scanner.nextLine();
        System.out.print("Введите исходную систему счисления: ");
        int originSys = scanner.nextInt();
        System.out.print("Введите конечную систему счисления: ");
        int finalSys = scanner.nextInt();
        scanner.close();

        Convert con = new Convert();
        String result = con.convert(number, originSys, finalSys);
        System.out.println("Результат: " + result);
    }
}
