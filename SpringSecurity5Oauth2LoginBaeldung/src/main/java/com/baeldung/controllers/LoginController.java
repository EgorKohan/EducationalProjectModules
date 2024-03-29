package com.baeldung.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@Profile("loginPage")
public class LoginController {

    private static String authorizationRequestBaseUri =
            "oauth2/authorization";

    private Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

//    private final ClientRegistrationRepository clientRegistrationRepository;
//
//    public LoginController(ClientRegistrationRepository clientRegistrationRepository) {
//        this.clientRegistrationRepository = clientRegistrationRepository;
//    }

    private final ApplicationContext applicationContext;

    public LoginController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/oauth_login")
    public String getLoginPage(Model model) {
//        Iterable<ClientRegistration> clientRegistrations = null;
//        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
//                .as(Iterable.class);
//
//        if (type != ResolvableType.NONE &&
//                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
//            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
//        }
//
//        clientRegistrations.forEach(clientRegistration ->
//                oauth2AuthenticationUrls.put(
//                        clientRegistration.getClientName(),
//                        authorizationRequestBaseUri + "/" + clientRegistration.getRegistrationId()
//                        )
//        );
//
//        model.addAttribute("urls", oauth2AuthenticationUrls);

        return "oauth_login";
    }

}
