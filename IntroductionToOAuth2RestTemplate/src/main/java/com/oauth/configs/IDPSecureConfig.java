package com.oauth.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Profile("idp")
@Configuration
@EnableOAuth2Client
public class IDPSecureConfig extends WebSecurityConfigurerAdapter {

    private final OAuth2ClientContext clientContext;

    public IDPSecureConfig(OAuth2ClientContext clientContext) {
        this.clientContext = clientContext;
    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate() {
        return new OAuth2RestTemplate(idpClient());
    }

    @Bean
    @ConfigurationProperties(prefix = "idp.client")
    public ClientCredentialsResourceDetails idpClient() {
        return new ClientCredentialsResourceDetails();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/idp/**").permitAll()
                .antMatchers("/hello", "/login/token", "repos", "/").permitAll()
                .anyRequest().authenticated();
    }
}
