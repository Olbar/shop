package org.levelup.shop.controller;


import org.levelup.shop.service.AuthorizationSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
public class LogoutController {
    private final AuthorizationSessionService authSessionService;

    @Autowired
    public LogoutController(AuthorizationSessionService authSessionService) {
        this.authSessionService = authSessionService;
    }

    @GetMapping("/logout")
    public String logout(@CookieValue("WC_SESSION") final String sid,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        authSessionService.removeSession(sid);

        Cookie[] cookies = request.getCookies();
        Cookie cookie1 = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("WC_SESSION"))
                .findFirst()
                .get();

        cookie1.setMaxAge(0);
        response.addCookie(cookie1);

        return "redirect:/login";
    }

}

