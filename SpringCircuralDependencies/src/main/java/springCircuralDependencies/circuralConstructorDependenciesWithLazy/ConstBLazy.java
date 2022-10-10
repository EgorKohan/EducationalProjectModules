package springCircuralDependencies.circuralConstructorDependenciesWithLazy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConstBLazy {

    private final ConstALazy constA;

    @Autowired
    public ConstBLazy(@Lazy ConstALazy constA) {
        this.constA = constA;
    }

    public void printConstA(){
        log.info("ConstA: {}", constA);
    }

}
