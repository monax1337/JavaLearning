package model;

import java.util.ArrayList;
import java.util.List;

public class UiMenu {

    public enum MESSAGE_TYPE {
        INFO("INFO"), WARNING("WARN"), ERROR("ERR");

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

    public static void exit(String s) {

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
