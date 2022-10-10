package springCircuralDependencies;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springCircuralDependencies.circuralDependenciesWithPostConstruct.PostConstA;
import springCircuralDependencies.config.TestPostConstConfig;

@ContextConfiguration(classes = TestPostConstConfig.class)
public class TestPostConstDependencies extends AbstractTestClass {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void loadContext_getMessageFromBeanB_thenSuccess() {
        PostConstA postConstA = applicationContext.getBean("postConstA", PostConstA.class);
        Assert.assertEquals("Hi", postConstA.getConstB().getMessage());
    }

}
