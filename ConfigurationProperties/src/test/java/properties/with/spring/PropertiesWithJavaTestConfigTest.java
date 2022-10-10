package properties.with.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@TestPropertySource({"classpath:testexample.properties"})
class PropertiesWithJavaTestConfigTest extends AbstractTest{

    @Value("${example.str.two}")
    private String strTwo;

    @Value("${example.str:}")
    private String str;

    @Test
    void values_readThem_success() {
        Assertions.assertEquals("test", strTwo);
        Assertions.assertEquals("", str);
    }

}
