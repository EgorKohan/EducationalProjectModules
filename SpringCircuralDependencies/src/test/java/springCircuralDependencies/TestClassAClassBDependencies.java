package springCircuralDependencies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springCircuralDependencies.config.TestConfigWithInitializingBeanAndApplicationContextAware;
import springCircuralDependencies.iplementInitilizingBeanAndApplicationContextAware.ClassA;

@ContextConfiguration(classes = {TestConfigWithInitializingBeanAndApplicationContextAware.class})
public class TestClassAClassBDependencies extends AbstractTestClass{

    @Autowired
    private ClassA classA;

    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void classA_invokeGetMessageFromClassB_thenSuccess() {
        Assert.assertEquals("Hi", classA.getClassB().getMessage());
    }

}
