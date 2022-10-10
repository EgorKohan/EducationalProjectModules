package patterns.state.common_example;

public class PublishedState extends DocumentState {

    public PublishedState(Document document) {
        super(document);
    }

    @Override
    public String publish() {
        return "Document is already published";
    }

    @Override
    public String reject() {
        if (document.isAdmin()) {
            document.setState(new ModerationState(document));
            return "Document was rejected to moderation";
        } else {
            return "You haven't permission to do this action";
        }
    }

    @Override
    public String getState() {
        return "Published";
    }
}
