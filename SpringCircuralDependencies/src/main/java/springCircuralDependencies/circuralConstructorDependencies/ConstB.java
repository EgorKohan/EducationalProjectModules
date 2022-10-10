package springCircuralDependencies.circuralConstructorDependencies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConstB {

    private final ConstA constA;

    @Autowired
    public ConstB(ConstA constA) {
        this.constA = constA;
    }

    public void printConstA(){
        log.info("ConstA: {}", constA);
    }

}
