package springCircuralDependencies.circuralConstructorDependencies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConstA {

    private final ConstB constB;

    @Autowired
    public ConstA(ConstB constB) {
        this.constB = constB;
    }

    public void printConstB() {
        log.info("ConstB: {}", constB);
    }

}
