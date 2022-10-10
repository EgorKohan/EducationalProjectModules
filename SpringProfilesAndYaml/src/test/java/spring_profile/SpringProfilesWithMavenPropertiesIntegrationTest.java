package spring_profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SpringProfilesWithMavenPropertiesIntegrationTest extends AbstractTest {

    @Autowired
    private DatasourceConfig datasourceConfig;

    @Test
    void setupDatasource() {
        Assertions.assertEquals("Setting up datasource for DEV environment", datasourceConfig.setup());
    }

}
