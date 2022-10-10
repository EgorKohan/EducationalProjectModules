package springCircuralDependencies.circuralFieldDependencies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FieldB {

    private final String message = "Hi";

    @Autowired
    private FieldA fieldA;

    public String printHi(){
        return message;
    }

}
