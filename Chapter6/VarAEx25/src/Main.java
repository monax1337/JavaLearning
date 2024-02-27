import java.util.Scanner;

import static processes.ProcessBSUApplicant.processBSUApplicant;
import static processes.ProcessBSUIRApplicant.processBSUIRApplicant;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите университет (BSU или BSUIR):");
        String university = scanner.nextLine();

        switch (university) {
            case "BSU":
                processBSUApplicant();
                break;
            case "BSUIR":
                processBSUIRApplicant();
                break;
            default:
                System.out.println("Некорректный выбор университета.");
        }

        scanner.close();
    }
}
