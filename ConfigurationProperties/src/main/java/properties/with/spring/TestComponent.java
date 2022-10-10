package properties.with.spring;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    private final DatabaseHierarchicalProperties databaseHierarchicalProperties;

    public TestComponent(DatabaseHierarchicalProperties databaseHierarchicalProperties) {
        this.databaseHierarchicalProperties = databaseHierarchicalProperties;
    }

    public String returnUrl() {
        return databaseHierarchicalProperties.getUrl();
    }

}
