package springCircuralDependencies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springCircuralDependencies.circuralFieldDependencies.FieldA;
import springCircuralDependencies.config.TestFieldConfig;

@ContextConfiguration(classes = {TestFieldConfig.class})
public class TestFieldDependencies extends AbstractTestClass {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * In this case beans will have links to each other
     */

    @Test
    public void testConfig_invokePrintHiMethod_thenSuccess() {
        FieldA bean = applicationContext.getBean(FieldA.class, FieldA.class);
        Assert.assertEquals("Hi", bean.getFieldB().printHi());
    }

}
