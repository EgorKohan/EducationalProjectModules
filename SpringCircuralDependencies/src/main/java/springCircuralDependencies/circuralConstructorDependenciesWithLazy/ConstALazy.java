package springCircuralDependencies.circuralConstructorDependenciesWithLazy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConstALazy {

    private final ConstBLazy constB;

    @Autowired
    public ConstALazy(@Lazy ConstBLazy constB) {
        this.constB = constB;
    }

    public void printConstB() {
        log.info("ConstB: {}", constB);
    }

}
