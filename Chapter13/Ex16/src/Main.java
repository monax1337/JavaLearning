import poems.model.UiItem;
import poems.model.UiMenu;

import java.util.Scanner;

import static poems.model.UiMenu.*;

public class Main {
    private static final UiMenu uiMenu;
    public static final Scanner scanner = new Scanner(System.in);

    static {
        uiMenu = new UiMenu.Builder()
                .addDescription("Список доступных действий:")
                .addItem(new UiItem(1, "Добавить стихотворение", UiMenu -> insertPoemMenu(scanner)))
                .addItem(new UiItem(2, "Изменить стихотворение", UiMenu -> updatePoemMenu(scanner)))
                .addItem(new UiItem(3, "Удалить стихотворение", UiMenu -> deletePoemMenu(scanner)))
                .addItem(new UiItem(4, "Стихотворение в котором больше всего восклицательных предложений", UiMenu -> mostExclamationSentencesMenu(scanner)))
                .addItem(new UiItem(5, "Стихотворение в котором меньше всего повествовательных предложений", UiMenu -> leastDeclarativeSentencesMenu(scanner)))
                .addItem(new UiItem(6, "Количество сонет у автора", UiMenu -> countSonnets(scanner)))
                .addItem(new UiItem(7, "Выйти", UiMenu::exit))
                .build();
    }

    public static void main(String[] args) {
        while (!UiMenu.exitFlag) {
            uiMenu.printMenu();
            String input = getInput();
            handleInput(input);
        }
        scanner.close();
    }

    private static String getInput() {
        System.out.print("Введите номер опции: ");
        return scanner.nextLine();
    }

    private static void handleInput(String input) {
        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= Main.uiMenu.getItems().size()) {
                UiItem selectedItem = Main.uiMenu.getItems().get(choice - 1);
                selectedItem.getAction().accept("");
            } else if (choice == Main.uiMenu.getItems().size() + 1) {
                UiMenu.exit("");
            } else {
                Main.uiMenu.printMessage(UiMenu.MESSAGE_TYPE.ERROR, "Некорректный ввод, попробуйте еще раз.");
            }
        } catch (NumberFormatException e) {
            Main.uiMenu.printMessage(UiMenu.MESSAGE_TYPE.ERROR, "Ошибка ввода, пожалуйста, попробуйте еще раз.");
        }
    }
}

