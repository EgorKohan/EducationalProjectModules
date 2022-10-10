package com.baeldung.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Profile("manual")
@Configuration
public class SecureClientRepositoriesConfig extends WebSecurityConfigurerAdapter {

    private static final String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";

    private static final List<String> clients = List.of("github");

    private final Environment environment;


    public SecureClientRepositoriesConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> collect = clients.stream()
                .map(this::getRegistration)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return new InMemoryClientRegistrationRepository(collect);
    }

    @Nullable
    private ClientRegistration getRegistration(String registrationId) {
        String clientId = environment.getProperty(CLIENT_PROPERTY_KEY + registrationId + ".clientId");
        if (clientId == null) return null;
        String clientSecret = environment.getProperty(CLIENT_PROPERTY_KEY + registrationId + ".clientSecret");

        if ("github".equals(clientSecret)) {
            return CommonOAuth2Provider.GITHUB.getBuilder(registrationId)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .build();
        }

        return null;

    }

    @Bean
    public OAuth2AuthorizedClientService oAuth2AuthorizedClientService(){
        return new InMemoryOAuth2AuthorizedClientService(
                clientRegistrationRepository()
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository())
                .authorizedClientService(oAuth2AuthorizedClientService());
    }

    //Не закончил до конца https://www.baeldung.com/spring-security-5-oauth2-login

}
