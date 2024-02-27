package processes;

import applicant.impl.BSUApplicant;

import java.util.Scanner;

public class ProcessBSUApplicant {
    public static void processBSUApplicant() {
        BSUApplicant bsuApplicant = new BSUApplicant();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 5) {
            System.out.println("Выберите действие для абитуриента БГУ:");
            System.out.println("1. Получить аттестат");
            System.out.println("2. Заполнить заявление");
            System.out.println("3. Зарегистрироваться на экзамены");
            System.out.println("4. Подать документы");
            System.out.println("5. Выйти");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bsuApplicant.obtainCertificate();
                    break;
                case 2:
                    bsuApplicant.fillApplication();
                    break;
                case 3:
                    bsuApplicant.registerForExams();
                    break;
                case 4:
                    bsuApplicant.submitDocuments();
                    break;
                case 5:
                    System.out.println("Выход из меню для абитуриента БГУ.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }

        scanner.close();
    }
}
