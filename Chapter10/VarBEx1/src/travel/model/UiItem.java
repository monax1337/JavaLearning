package travel.model;

import java.util.function.Consumer;

public class UiItem {
    private int selectionId;
    private String description;
    private final Consumer<String> action;

    public UiItem(int selectionId, String description, Consumer<String> action) {
        this.selectionId = selectionId;
        this.description = description;
        this.action = action;
    }

    public int getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(int selectionId) {
        this.selectionId = selectionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consumer<String> getAction() {
        return action;
    }
}
