package org.levelup.shop.controller;

import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

    private final AuthenticationService authService;

    @Autowired
    public AuthorizationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login_error")
    public String loginPageError() {
        return "login_error";
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") final String login,
                        @RequestParam("password") final String password) {
        boolean result = authService.authenticate(login, password);
        return result ? "redirect:/items" : "redirect:/login_error";
    }
}
