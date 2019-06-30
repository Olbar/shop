package org.levelup.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.levelup.shop.domain.dto.AuthorizationRequest;
import org.levelup.shop.domain.dto.UserSession;
import org.levelup.shop.service.AuthenticationService;
import org.levelup.shop.service.AuthorizationSessionService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class AuthorizationController {

    private final AuthenticationService authService;
    private final AuthorizationSessionService authSessionService;

    @Autowired
    public AuthorizationController(AuthenticationService authService, AuthorizationSessionService authSessionService) {
        this.authService = authService;
        this.authSessionService = authSessionService;
    }


    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("request", new AuthorizationRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("request") AuthorizationRequest request,
                        BindingResult bindingResult,
                        HttpServletResponse response) {
        boolean result = authService.authenticate(request.getLogin(), request.getPassword());
        if (!result) {
            bindingResult.rejectValue("login", "");
            return "login";
        }

        UserSession session = authSessionService.createOrUpdateSession(request.getLogin());
        System.out.println(request.getLogin());
        response.addCookie(new Cookie("WC_SESSION", session.getSid()));
        System.out.println(response);
        System.out.println(session.getSid());
        return "redirect:/items";
    }
}
