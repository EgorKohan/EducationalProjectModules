package spring_profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests make it very easy to specify what profiles are active using the @ActiveProfile annotation to enable specific profiles:
 *
 * @ActiveProfiles("dev") So far, we've looked at multiple ways of activating profiles. Let's now see which one has priority over the other and what happens if we use more than one, from highest to lowest priority:
 * <p>
 * Context parameter in web.xml
 * WebApplicationInitializer
 * JVM System parameter
 * Environment variable
 * Maven profile
 */

class TestClassWithActiveDevProfile extends AbstractTest {

    @Autowired
    private ProfileManager profileManager;

    @Value("${spring.profiles.active:}")
    private String profile;

    @Test
    void profileManager_getSpringActiveProfiles_thenSuccess() {
        assertEquals(List.of("dev"), profileManager.getActiveProfilesFromEnvironment());
        assertEquals("dev", profileManager.getActiveProfilesFromValue());
    }

}
