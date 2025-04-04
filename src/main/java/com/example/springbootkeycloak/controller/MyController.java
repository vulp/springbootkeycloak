package com.example.springbootkeycloak.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/secured")
    public String securedPage(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            String currentUserName = principal.getPreferredUsername();
            model.addAttribute("username", currentUserName);
        }
        return "secured";
    }

    @GetMapping("/logout")
    public String logout(org.springframework.security.core.Authentication authentication, jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException {
        if (authentication != null && authentication.isAuthenticated()) {
            request.logout(); //TODO move these codes to securityconfig
            String logoutUri = "http://localhost:8080/realms/demo/protocol/openid-connect/logout";
            String clientId = "spring-boot-app";
            String postLogoutRedirectUri = "http://localhost:8081/";
            String logoutUrlWithParams = logoutUri + "?client_id=" + clientId + "&post_logout_redirect_uri=" + postLogoutRedirectUri;
            return "redirect:" + logoutUrlWithParams;
        }
        return "redirect:/";
    }
}

