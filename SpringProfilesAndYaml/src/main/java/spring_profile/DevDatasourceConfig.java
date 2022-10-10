package spring_profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * We annotate that bean with a dev profile,
 * and it will only be present in the container during development. In production, the dev simply won't be active:
 * <p>
 * As a quick sidenote, profile names can also be prefixed with a NOT operator, e.g., !dev, to exclude them from a profile.
 * <p>
 * In the example, the component is activated only if dev profile is not active:
 * <p>
 * Profiles can also be configured in XML. The <beans> tag has a profile attribute, which takes comma-separated values of the applicable profiles:
 *
 * <beans profile="dev">
 * <bean id="devDatasourceConfig"
 * class="org.baeldung.profiles.DevDatasourceConfig" />
 * </beans>
 */

@Component
@Profile("dev")
@Slf4j
//@Profile("!dev")
public class DevDatasourceConfig implements DatasourceConfig {
    @Override
    public String setup() {
        return "Setting up datasource for DEV environment";
    }
}
