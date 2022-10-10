package springCircuralDependencies.iplementInitilizingBeanAndApplicationContextAware;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ClassA implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;
    @Getter
    private ClassB classB;

    @Override
    public void afterPropertiesSet() throws Exception {
        classB = applicationContext.getBean(ClassB.class);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
