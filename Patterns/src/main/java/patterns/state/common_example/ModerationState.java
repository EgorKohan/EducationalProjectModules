package patterns.state.common_example;

public class ModerationState extends DocumentState {

    public ModerationState(Document document) {
        super(document);
    }

    @Override
    public String publish() {
        if (document.isAdmin()) {
            document.setState(new PublishedState(document));
            return "Document was published";
        } else {
            return "You haven't permission to do this action";
        }
    }

    @Override
    public String reject() {
            document.setState(new DraftState(document));
            return "Document was rejected";
    }

    @Override
    public String getState() {
        return "Moderating";
    }
}
