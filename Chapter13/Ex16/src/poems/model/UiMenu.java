package poems.model;

import poems.database.DatabaseConnection;
import poems.service.ModifyPoemsService;
import poems.service.QueryPoemsService;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static void insertPoemMenu(Scanner scanner){
        System.out.println("Введите автора стихотворения:");
        String author = scanner.nextLine();
        System.out.println("Введите год создания стихотворения:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите текст стихотворения:");
        String contentStr = scanner.nextLine();

        Clob content = StringToClob(contentStr);
        try{
            ModifyPoemsService.insertPoem(author,year, content);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updatePoemMenu(Scanner scanner){
        System.out.println("Введите id стихотворения:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите новый текст стихотворения:");
        String contentStr =  scanner.nextLine();

        Clob content = StringToClob(contentStr);
        try{
            ModifyPoemsService.updatePoem(id, content);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deletePoemMenu(Scanner scanner){
        System.out.println("Введите id стихотворения:");
        int id = scanner.nextInt();
        scanner.nextLine();
        try{
            ModifyPoemsService.deletePoem(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Clob StringToClob(String s) {
        Clob content;
        try {
            Connection conn = DatabaseConnection.getConnection();
            content = conn.createClob();
            content.setString(1, s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public static void mostExclamationSentencesMenu(Scanner scanner) {
        System.out.println("Введите автора:");
        String author = scanner.nextLine();

        try{
            QueryPoemsService.mostExclamationSentences(author);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leastDeclarativeSentencesMenu(Scanner scanner) {
        System.out.println("Введите автора:");
        String author = scanner.nextLine();

        try{
            QueryPoemsService.leastDeclarativeSentences(author);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void countSonnets(Scanner scanner) {
        System.out.println("Введите автора:");
        String author = scanner.nextLine();

        try{
            QueryPoemsService.countSonnets(author);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
