import java.util.Scanner;

import static processes.ProcessPoem.processPoem;
import static processes.ProcessWhiteVerse.processWhiteVerse;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Какой тип стихотворения вы хотите создать?");
            System.out.println("1. Стихотворение");
            System.out.println("2. Белый стих");
            System.out.println("3. Выйти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processPoem();
                    break;
                case 2:
                    processWhiteVerse();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }

        scanner.close();
    }
}
