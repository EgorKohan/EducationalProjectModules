package springCircuralDependencies.iplementInitilizingBeanAndApplicationContextAware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassB {

    private ClassA classA;

    @Autowired
    public void setClassA(ClassA classA) {
        this.classA = classA;
    }

    private String message = "Hi";

    public String getMessage(){
        return message;
    }

}
