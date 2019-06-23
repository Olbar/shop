package org.levelup.shop.controller;

import org.levelup.shop.domain.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") final String login,
                        @RequestParam("password") final String password) {
        System.out.println(login);
        System.out.println(password);
            return "redirect:/items";
    }
}
