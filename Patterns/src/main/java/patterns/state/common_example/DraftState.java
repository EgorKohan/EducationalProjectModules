package patterns.state.common_example;

public class DraftState extends DocumentState {

    public DraftState(Document document) {
        super(document);
    }

    @Override
    public String publish() {
        String text = document.getText();
        if (text.length() < 5) {
            return "Text is too small";
        } else {
            document.setState(new ModerationState(document));
            return "Text is on moderation";
        }
    }

    @Override
    public String reject() {
        return "Document is already in draft";
    }

    @Override
    public String getState() {
        return "Draft";
    }


}
