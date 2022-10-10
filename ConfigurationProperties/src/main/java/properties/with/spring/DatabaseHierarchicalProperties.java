package properties.with.spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties(prefix = "database")
public class DatabaseHierarchicalProperties {

    private String url;
    private String username;
    private String password;

}
