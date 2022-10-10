package patterns.state.common_example;

import lombok.Getter;
import lombok.Setter;

public class Document {

    private final String title;
    @Setter
    @Getter
    private DocumentState state;
    @Getter
    @Setter
    private String text;
    @Setter
    @Getter
    private boolean isAdmin;

    public Document(String title, String text) {
        this.state = new DraftState(this);
        this.text = text;
        this.title = title;
    }

    @Override
    public String toString() {
        return title + ": " + text.substring(1, 10) + "... - " + state.getState();
    }
}
