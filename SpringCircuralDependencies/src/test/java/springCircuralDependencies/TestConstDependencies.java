package springCircuralDependencies;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springCircuralDependencies.config.TestConstConfig;

/**
 * This test will always fail due context error due beans invalid creation
 */

@ContextConfiguration(classes = {TestConstConfig.class})
public class TestConstDependencies extends AbstractTestClass {

    @Test(expected = BeanCurrentlyInCreationException.class)
    @Ignore
    public void contextLoad_LoadCircularConstBeans_ThenFail() {
    }

}
