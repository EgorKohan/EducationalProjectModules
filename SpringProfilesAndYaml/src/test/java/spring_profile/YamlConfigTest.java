package spring_profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
class YamlConfigTest extends AbstractTest {

    @Autowired
    private YamlConfig yamlConfig;

    @Test
    void yamlConfig_checkParameters_thenSuccess() {
        System.out.println(yamlConfig.getName());
        System.out.println(yamlConfig.getEnvironment());
    }

}
