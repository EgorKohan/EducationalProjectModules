package properties.with.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"foo = test", "foo2 = test2"})
class DirectlyPropertiesTest extends AbstractTest{

    @Value("${foo}")
    private String str;

    @Value("${foo2}")
    private String str2;

    @Test
    void foo_read_success(){
        Assertions.assertEquals("test", str);
        Assertions.assertEquals("test2", str2);
    }

}
