package travel;

import travel.abstracttours.Tour;
import travel.model.UiMenu;
import travel.model.UiItem;
import travel.service.TourConnectorService;
import travel.tours.ExcursionTour;
import travel.tours.HealthTour;
import travel.tours.RelaxationTour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static travel.model.UiMenu.printTours;

public class Main {
    private static final UiMenu uiMenu;
    public static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter10\\VarBEx1\\src\\resources\\serialized\\tours.XML";
    private static final TourConnectorService tourConnectorService = new TourConnectorService(FILE_PATH);

    public static List<Tour> tours = new ArrayList<>(List.of(
            new RelaxationTour("Греция", "Самолет", "Отель", 7, 1000),
            new ExcursionTour("Италия", "Поезд", "Апартаменты", 5, 800),
            new HealthTour("Испания", "Самолет", "Санаторий", 10, 1500)
    ));

    static {
        uiMenu = new UiMenu.Builder()
                .addDescription("Список доступных действий:")
                .addItem(new UiItem(1, "Все доступные туры", UiMenu -> printTours(Main.tours)))
                .addItem(new UiItem(2, "Сортировка по цене", UiMenu::processPrice))
                .addItem(new UiItem(3, "Сортировка по продолжительности", UiMenu::processDuration))
                .addItem(new UiItem(4, "Сохранить туры в файл", s -> tourConnectorService.saveTours(Main.tours)))
                .addItem(new UiItem(5, "Загрузить туры из файла", s -> Main.tours = tourConnectorService.loadTours()))
                .addItem(new UiItem(6, "Выйти", UiMenu::exit))
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
