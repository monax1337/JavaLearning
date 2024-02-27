package processes;

import literary.impl.WhiteVerse;

import java.util.Scanner;

public class ProcessWhiteVerse {
    public static void processWhiteVerse() {
        WhiteVerse whiteVerse = new WhiteVerse();
        Scanner scanner = new Scanner(System.in);
        int action;

        do {
            System.out.println("Что вы хотите сделать с этим белым стихом?");
            System.out.println("1. Написать");
            System.out.println("2. Отредактировать");
            System.out.println("3. Опубликовать");
            System.out.println("4. Посвятить");
            System.out.println("5. Перевести");
            System.out.println("6. Продать права");
            System.out.println("7. Получить критику");
            System.out.println("8. Определить схему рифмовки");
            System.out.println("9. Выйти");

            action = scanner.nextInt();

            switch (action) {
                case 1:
                    whiteVerse.write();
                    break;
                case 2:
                    whiteVerse.edit();
                    break;
                case 3:
                    whiteVerse.publish();
                    break;
                case 4:
                    System.out.println("Чему вы хотите посвятить белый стих?");
                    scanner.nextLine();
                    String dedication = scanner.nextLine();
                    whiteVerse.dedicate(dedication);
                    break;
                case 5:
                    System.out.println("На какой язык вы хотите перевести белый стих?");
                    scanner.nextLine();
                    String language = scanner.nextLine();
                    whiteVerse.translate(language);
                    break;
                case 6:
                    whiteVerse.sellRights();
                    break;
                case 7:
                    whiteVerse.receiveCritique();
                    break;
                case 8:
                    System.out.println("Какую схему рифмовки вы хотите определить для белого стиха?");
                    scanner.nextLine();
                    String rhymeScheme = scanner.nextLine();
                    whiteVerse.writeRhymeScheme(rhymeScheme);
                    break;
                case 9:
                    System.out.println("Выход из меню для белого стиха.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        } while (action != 9);

        scanner.close();
    }
}
