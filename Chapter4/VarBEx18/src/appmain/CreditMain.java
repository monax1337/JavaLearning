package appmain;

import credit.Credit;
import credit.EarlyRepaymentCredit;
import credit.IncreasedCreditLimit;

import java.util.Scanner;

public class CreditMain {
    public static void main(String[] args) {
        EarlyRepaymentCredit credit1 = new EarlyRepaymentCredit("Bank A", 10.5, 50000, true);
        IncreasedCreditLimit credit2 = new IncreasedCreditLimit("Bank B", 9.5, 70000, 150000);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Досрочное погашение кредита");
            System.out.println("2. Увеличение кредитной линии");
            System.out.println("3. Выход");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите сумму для досрочного погашения:");
                    int repaymentAmount = scanner.nextInt();
                    System.out.println("Выберите кредит:");
                    System.out.println("1. " + credit1.getBankName());
                    System.out.println("2. " + credit2.getBankName());
                    int creditChoice = scanner.nextInt();
                    if (creditChoice == 1) {
                        credit1.makeEarlyRepayment(repaymentAmount);
                    } else if (creditChoice == 2) {
                        System.out.println("Выбранный кредит не поддерживает досрочное погашение.");
                    } else {
                        System.out.println("Некорректный выбор кредита.");
                    }
                    break;
                case 2:
                    System.out.println("Введите сумму для увеличения кредитной линии:");
                    int increaseAmount = scanner.nextInt();
                    System.out.println("Выберите кредит:");
                    System.out.println("1. " + credit1.getBankName());
                    System.out.println("2. " + credit2.getBankName());
                    creditChoice = scanner.nextInt();
                    if (creditChoice == 1) {
                        System.out.println("Выбранный кредит не поддерживает увеличение кредитной линии.");
                    } else if (creditChoice == 2) {
                        credit2.increaseCreditLimit(increaseAmount);
                    } else {
                        System.out.println("Некорректный выбор кредита.");
                    }
                    break;
                case 3:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        } while (choice != 3);
    }
}
