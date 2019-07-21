package org.levelup.shop.controller;


import org.levelup.shop.domain.dto.CheckoutRequest;
import org.levelup.shop.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String checkOutRequest(@ModelAttribute("request") final CheckoutRequest request,
                                  @CookieValue("WC_SESSION") final String sid) {
        сheckoutService.checkout(sid, request);
        return "redirect:/orders";
    }
}
