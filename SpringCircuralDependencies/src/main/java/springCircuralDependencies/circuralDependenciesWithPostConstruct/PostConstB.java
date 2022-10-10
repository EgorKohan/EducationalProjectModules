package springCircuralDependencies.circuralDependenciesWithPostConstruct;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PostConstB {

    @Setter
    private PostConstA postConstA;

    public String getMessage(){
        return "Hi";
    }

}
