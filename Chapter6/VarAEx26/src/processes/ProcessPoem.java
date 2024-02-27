package processes;

import literary.impl.Poem;

import java.util.Scanner;

public class ProcessPoem {
    public static void processPoem() {
        Poem poem = new Poem();
        Scanner scanner = new Scanner(System.in);
        int action;

        do {
            System.out.println("Что вы хотите сделать с этим стихотворением?");
            System.out.println("1. Написать");
            System.out.println("2. Отредактировать");
            System.out.println("3. Опубликовать");
            System.out.println("4. Посвятить");
            System.out.println("5. Перевести");
            System.out.println("6. Продать права");
            System.out.println("7. Получить критику");
            System.out.println("8. Выйти");

            action = scanner.nextInt();

            switch (action) {
                case 1:
                    poem.write();
                    break;
                case 2:
                    poem.edit();
                    break;
                case 3:
                    poem.publish();
                    break;
                case 4:
                    System.out.println("Кому вы хотите посвятить стихотворение?");
                    scanner.nextLine();
                    String dedication = scanner.nextLine();
                    poem.dedicate(dedication);
                    break;
                case 5:
                    System.out.println("На какой язык вы хотите перевести стихотворение?");
                    scanner.nextLine();
                    String language = scanner.nextLine();
                    poem.translate(language);
                    break;
                case 6:
                    poem.sellRights();
                    break;
                case 7:
                    poem.receiveCritique();
                    break;
                case 8:
                    System.out.println("Выход из меню для стихотворения.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        } while (action != 8);

        scanner.close();
    }
}
