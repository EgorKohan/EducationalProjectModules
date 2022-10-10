package springCircuralDependencies.circuralDependenciesWithPostConstruct;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class PostConstA {

    @Getter
    @Autowired
    private PostConstB constB;

    @PostConstruct
    public void setup() {
        constB.setPostConstA(this);
    }

    public PostConstA(PostConstB constB) {
        this.constB = constB;
    }

}
