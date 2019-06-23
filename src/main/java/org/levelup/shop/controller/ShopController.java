package org.levelup.shop.controller;


import org.levelup.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/items")
    public String displayAllItems(Model model) {
        model.addAttribute("items", shopService.getAll());
        return "items";
    }
}
