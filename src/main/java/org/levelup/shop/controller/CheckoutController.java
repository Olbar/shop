package org.levelup.shop.controller;


import org.levelup.shop.domain.dto.CheckoutRequest;
import org.levelup.shop.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService сheckoutService;

    @Autowired
    public CheckoutController(CheckoutService сheckoutService) {
        this.сheckoutService = сheckoutService;
    }


    @GetMapping
    public String displayCheckout(Model model) {
        model.addAttribute("request", new CheckoutRequest());
        return "checkout";
    }

    @PostMapping
    public String checkOut(@ModelAttribute("request") final CheckoutRequest request) {
        сheckoutService.checkout(request);
        return "redirect:/categories";
    }
}
