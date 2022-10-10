package springCircuralDependencies.circuralFieldDependencies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FieldA {

    @Autowired
    private FieldB fieldB;

    public FieldB getFieldB(){
        return fieldB;
    }

}
