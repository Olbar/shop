package org.levelup.shop.controller;

import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basket")
public class BasketController {

    private final AuthorizationSessionService authSessionService;
    private final BasketService basketService;


    @Autowired
    public BasketController(BasketService basketService, AuthorizationSessionService authSessionService) {
        this.basketService = basketService;
        this.authSessionService = authSessionService;
    }

    @GetMapping
    public String displayCategories(@CookieValue("WC_SESSION") final String sid, Model model) {
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        model.addAttribute( "basket", basketService.findAllItemsByUserId(userId) );
        return "basket";
    }
}
