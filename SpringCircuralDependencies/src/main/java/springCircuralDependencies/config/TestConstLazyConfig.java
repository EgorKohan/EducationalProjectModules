package springCircuralDependencies.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("springCircuralDependencies.circuralConstructorDependenciesWithLazy")
public class TestConstLazyConfig {
}
