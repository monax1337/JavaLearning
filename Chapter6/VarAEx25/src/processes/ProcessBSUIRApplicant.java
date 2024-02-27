package processes;

import applicant.impl.BSUIRApplicant;

import java.util.Scanner;

public class ProcessBSUIRApplicant {
    public static void processBSUIRApplicant() {
        BSUIRApplicant bsuirApplicant = new BSUIRApplicant();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 6) {
            System.out.println("Выберите действие для абитуриента БГУИР:");
            System.out.println("1. Получить аттестат");
            System.out.println("2. Заполнить заявление");
            System.out.println("3. Зарегистрироваться на экзамены");
            System.out.println("4. Подать документы");
            System.out.println("5. Дополнительный метод");
            System.out.println("6. Выйти");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bsuirApplicant.obtainCertificate();
                    break;
                case 2:
                    bsuirApplicant.fillApplication();
                    break;
                case 3:
                    bsuirApplicant.registerForExams();
                    break;
                case 4:
                    bsuirApplicant.submitDocuments();
                    break;
                case 5:
                    bsuirApplicant.admissionRules();
                    break;
                case 6:
                    System.out.println("Выход из меню для абитуриента БГУИР.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }

        scanner.close();
    }
}
