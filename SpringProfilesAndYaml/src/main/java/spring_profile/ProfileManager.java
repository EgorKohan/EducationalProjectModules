package spring_profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProfileManager {

    private final Environment environment;

    /**
     * However, we should consider what would happen if there is no active profile at all.
     * With our code above, the absence of an active profile would prevent the application context from being created.
     * This would result in an IllegalArgumentException owing to the missing placeholder for injecting into the variable.
     *
     * In order to avoid this, we can define a default value:
     * @Value("${spring.profiles.active:}")
     */

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @Autowired
    public ProfileManager(Environment environment) {
        this.environment = environment;
    }

    public List<String> getActiveProfilesFromEnvironment() {
        return List.of(environment.getActiveProfiles());
    }

    public String getActiveProfilesFromValue() {
        return activeProfile;
    }

}
