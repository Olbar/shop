package org.levelup.shop.controller;


import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {


    private final AuthorizationSessionService authSessionService;
    private final OrderService orderService;

    @Autowired
    public OrderController(AuthorizationSessionService authSessionService, OrderService orderService) {
        this.authSessionService = authSessionService;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String ordersPage(@CookieValue("WC_SESSION") final String sid, Model model) {
        Integer userId = authSessionService.findUserIdBySessionId( sid );
        model.addAttribute("orders", orderService.findAllOrdersForUser( userId ));
        return "orders";
    }
}
