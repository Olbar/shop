package org.levelup.shop.controller;

import org.levelup.shop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basket")
public class BasketController {


    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }


    @GetMapping
    public String displayCategories(Model model) {
        model.addAttribute( "basket", basketService.findAll() );
        return "basket";
    }
}
