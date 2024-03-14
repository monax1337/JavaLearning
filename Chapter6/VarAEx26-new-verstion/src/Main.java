import java.util.Scanner;
import model.UiItem;
import model.UiMenu;
import service.impl.LiteraryServiceImpl;

public class Main {
    private static final UiMenu uiMenu;
    static {
        uiMenu = new UiMenu.Builder()
            .addDescription("Какой тип стихотворения вы хотите создать?")
            .addItem(new UiItem(1, "Стихотворение", LiteraryServiceImpl::processPoem))
            .addItem(new UiItem(2, "Белый стих", LiteraryServiceImpl::processWhiteVerse))
            .addItem(new UiItem(3, "Выйти", UiMenu::exit))
            .build();
    }

    public static void main(String[] args) {
        uiMenu.printMenu();
        try(Scanner scanner = new Scanner(System.in)) {
            // uiMenu.getItemById(-> id).getAction().process();
        }


        uiMenu.printMessage(UiMenu.MESSAGE_TYPE.INFO, "Info message");
        uiMenu.printMessage(UiMenu.MESSAGE_TYPE.WARNING, "Warning message");
        uiMenu.printMessage(UiMenu.MESSAGE_TYPE.ERROR, "Error message");
    }
}
