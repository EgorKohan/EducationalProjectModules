package com.oauth.controllers;

import com.oauth.models.GithubRepo;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;

@Profile("baeldung")
@Controller
public class AppController {

    private final OAuth2RestTemplate restTemplate;


    public AppController(OAuth2RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/home")
    public String welcome(Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        return "/home";
    }

    @GetMapping("/repos")
    public String repos(Model model) {
        Collection<GithubRepo> repos = restTemplate.getForObject("https://api.github.com/user/repos", Collection.class);
        model.addAttribute("repos", repos);
        return "repositories";
    }

}
