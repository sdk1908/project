package com.mvc.oauth2.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile(OAuth2AuthenticationToken authentication, Model model) {
        model.addAttribute("user", authentication.getPrincipal().getAttributes());
        return "profile";
    }

    @GetMapping("/login/oauth2/code/google")
    public String home1() {
        return "google";
    }
}

