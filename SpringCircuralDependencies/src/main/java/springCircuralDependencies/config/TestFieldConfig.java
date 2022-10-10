package springCircuralDependencies.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("springCircuralDependencies.circuralFieldDependencies")
public class TestFieldConfig {
}
