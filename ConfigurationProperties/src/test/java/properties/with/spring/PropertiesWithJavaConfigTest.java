package properties.with.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {PropertiesWithJavaConfig.class})
class PropertiesWithJavaConfigTest extends AbstractTest {

    @Value("${example.str}")
    protected String str;

    @Test
    void config_readProperty_success() {
        Assertions.assertEquals("Hello", str);
    }


}