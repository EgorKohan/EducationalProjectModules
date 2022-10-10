package properties.with.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

class DatabaseHierarchicalPropertiesTest extends AbstractTest {

    @Autowired
    private TestComponent testComponent;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void databaseHierarchicalProperties_readFields_success() {
        Assertions.assertEquals("someUrl", testComponent.returnUrl());
    }

}