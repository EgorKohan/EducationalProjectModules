package patterns.state.common_example;

public abstract class DocumentState {

    protected final Document document;

    protected DocumentState(Document document) {
        this.document = document;
    }

    public abstract String publish();
    public abstract String reject();

    public abstract String getState();
}
