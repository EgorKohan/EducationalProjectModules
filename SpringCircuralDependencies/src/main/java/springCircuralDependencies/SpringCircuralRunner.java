package springCircuralDependencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. What Is a Circular Dependency?
 * A circular dependency occurs when a bean A depends on another bean B, and the bean B depends on bean A as well:
 *
 * Bean A → Bean B → Bean A
 *
 * Of course, we could have more beans implied:
 *
 * Bean A → Bean B → Bean C → Bean D → Bean E → Bean A
 *
 * 2. What Happens in Spring
 * When the Spring context loads all the beans, it tries to create beans in the order needed for them to work completely.
 *
 * Let's say we don't have a circular dependency. We instead have something like this:
 *
 * Bean A → Bean B → Bean C
 *
 * Spring will create bean C, then create bean B (and inject bean C into it), then create bean A (and inject bean B into it).
 *
 * But with a circular dependency, Spring cannot decide which of the beans should be
 * created first since they depend on one another. In these cases, Spring will raise
 * a BeanCurrentlyInCreationException while loading context.
 *
 * It can happen in Spring when using constructor injection. If we use other types
 * of injections, we shouldn't have this problem since the dependencies will be injected
 * when they are needed and not on the context loading.
 *
 */



@SpringBootApplication(scanBasePackages = "springCircuralDependencies")
public class SpringCircuralRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringCircuralRunner.class, args);
    }

}