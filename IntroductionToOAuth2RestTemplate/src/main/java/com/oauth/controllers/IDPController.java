package com.oauth.controllers;

import com.oauth.models.ClientCredentialsModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Profile("idp")
@RestController
@RequestMapping("/idp")
public class IDPController {

    private final Map<String, OAuth2RestTemplate> oAuth2RestTemplateMap = new HashMap<>();

    private final OAuth2RestTemplate oAuth2RestTemplate;

    private final ApplicationContext applicationContext;

    private final OAuth2ClientContext oAuth2ClientContext;

    public IDPController(
            OAuth2RestTemplate oAuth2RestTemplate,
            ApplicationContext applicationContext,
            OAuth2ClientContext oAuth2ClientContext
    ) {
        this.oAuth2RestTemplate = oAuth2RestTemplate;
        this.applicationContext = applicationContext;
        this.oAuth2ClientContext = oAuth2ClientContext;
    }

    @GetMapping("/token")
    public Object getToken(){
        return oAuth2RestTemplate.getAccessToken();
    }

    @PostMapping("/client-credentials")
    public String addClientCredentials(@RequestBody ClientCredentialsModel clientCredentialsModel) {
        ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
        clientCredentialsResourceDetails.setClientId(clientCredentialsModel.getClientId());
        clientCredentialsResourceDetails.setClientSecret(clientCredentialsModel.getClientSecret());
        clientCredentialsResourceDetails.setAccessTokenUri(clientCredentialsModel.getAccessTokenUri());
        clientCredentialsResourceDetails.setGrantType(ClientCredentialsModel.GRANT_TYPE);

        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(clientCredentialsResourceDetails ,oAuth2ClientContext);
        log.info("POST: {}", oAuth2RestTemplate.getAccessToken());
        String uuid = UUID.randomUUID().toString();
        oAuth2RestTemplateMap.put(uuid, oAuth2RestTemplate);
        return uuid;

    }

    @GetMapping("/token/{uuid}")
    public String getToken(@PathVariable("uuid") String uuid) {
        String value = oAuth2RestTemplateMap.get(uuid).getAccessToken().getValue();
        log.info("Token: {}", value);
        return value;
    }

}
