package spring_profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * In web applications, WebApplicationInitializer can be used to configure the ServletContext programmatically.
 *
 * It's also a very handy location to set our active profiles programmatically:
 *
 * We can also set profiles directly on the environment:
 *
 * Similarly, we can define the active profiles in the web.xml file of the web application, using a context parameter:
 *
 * <context-param>
 *     <param-name>contextConfigLocation</param-name>
 *     <param-value>/WEB-INF/app-config.xml</param-value>
 * </context-param>
 * <context-param>
 *     <param-name>spring.profiles.active</param-name>
 *     <param-value>dev</param-value>
 * </context-param>
 *
 * The profile names can also be passed in via a JVM system parameter. These profiles will be activated during application startup:
 *
 * <code>
 * -Dspring.profiles.active=dev
 * </code>
 *
 * In a Unix environment, profiles can also be activated via the environment variable:
 *
 * export spring_profiles_active=dev
 *
 */

@Configuration
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    private final ConfigurableEnvironment configurableEnvironment;

    public MyWebApplicationInitializer(ConfigurableEnvironment configurableEnvironment) {
        this.configurableEnvironment = configurableEnvironment;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        configurableEnvironment.setActiveProfiles("dev");

        servletContext.setInitParameter("spring.profiles.active", "dev");
    }

}
