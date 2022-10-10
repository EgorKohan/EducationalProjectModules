package spring_profile;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * The annotations used here are:
 *
 * @Configuration – this marks the class as a source of bean definitions
 * @ConfigurationProperties – this binds and validates the external configurations to a configuration class
 * @EnableConfigurationProperties – this annotation is used to enable @ConfigurationProperties annotated beans in the Spring application
 */

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.application")
@Data
public class YamlConfig {

    private String name;
    private String environment;
    private boolean enabled;
    private List<String> servers = new ArrayList<>();

}
