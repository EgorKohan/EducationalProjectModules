package springCircuralDependencies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springCircuralDependencies.config.TestConstLazyConfig;

@ContextConfiguration(classes = {TestConstLazyConfig.class})
public class TestConstLazyDependencies extends AbstractTestClass {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void success() {
        System.out.println(applicationContext.getDisplayName());
    }

}
