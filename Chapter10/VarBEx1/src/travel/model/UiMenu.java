package travel.model;

import travel.abstracttours.Tour;
import travel.service.TourSortService;
import travel.Main;

import java.util.ArrayList;
import java.util.List;

import static travel.Main.scanner;

public class UiMenu {
    public static boolean exitFlag = false;

    public enum MESSAGE_TYPE {
        ERROR("ERR");

        private final String value;

        MESSAGE_TYPE(String value) {
            this.value = value;
        }
    }

    private UiMenu() {}

    private String description;
    private List<UiItem> items;

    public String getDescription() {
        return description;
    }

    public List<UiItem> getItems() {
        return items;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private void setItems(List<UiItem> items) {
        this.items = items;
    }

    public void printMessage(MESSAGE_TYPE messageType, String message) {
        System.out.printf("%s: %s.\n", messageType.value, message);
    }

    public void printMenu() {
        System.out.println(description);
        for (UiItem item : items) {
            System.out.printf("%d. %s\n", item.getSelectionId(), item.getDescription());
        }
    }

    public static void processPrice(String s) {
        System.out.print("Введите нижнюю границу цены: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Введите верхнюю границу цены: ");
        double maxPrice = scanner.nextDouble();

        List<Tour> sortedTours = TourSortService.sortByPrice(Main.tours, minPrice, maxPrice);

        printTours(sortedTours);
    }

    public static void processDuration(String s) {
        System.out.print("Введите нижнюю границу продолжительности: ");
        int minDuration = scanner.nextInt();
        System.out.print("Введите верхнюю границу продолжительности: ");
        int maxDuration = scanner.nextInt();

        List<Tour> sortedTours = TourSortService.sortByDuration(Main.tours, minDuration, maxDuration);

        printTours(sortedTours);
    }

    public static void printTours(List<Tour> tours) {
        for (Tour tour : tours) {
            System.out.println(tour);
        }
    }

    public static void exit(String s) {
        exitFlag = true;
    }

    public static class Builder {
        private String description;
        private final List<UiItem> items;

        public Builder() {
            items = new ArrayList<>();
        }

        public Builder addDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder addItem(UiItem item) {
            items.add(item);
            return this;
        }

        public UiMenu build() {
            UiMenu menu = new UiMenu();
            menu.setDescription(description);
            menu.setItems(items);
            return menu;
        }
    }
}
