package org.levelup.shop.controller;

import org.levelup.shop.domain.dto.BasketData;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.BasketService;
import org.levelup.shop.service.DeletionService;
import org.levelup.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/basket")
public class BasketController {

    private final AuthorizationSessionService authSessionService;
    private final BasketService basketService;
    private final DeletionService deletionService;
    private final ItemService itemService;


    @Autowired
    public BasketController(BasketService basketService, AuthorizationSessionService authSessionService, ItemService itemService, DeletionService deletionService) {
        this.basketService = basketService;
        this.authSessionService = authSessionService;
        this.deletionService = deletionService;
        this.itemService = itemService;
    }

    @GetMapping
    public String displayCategories(@CookieValue("WC_SESSION") final String sid, Model model) {
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        model.addAttribute( "baskets", basketService.findAllBasketsByUserId( userId ) );
        return "basket";
    }

    @ResponseBody
    @DeleteMapping("/{basketId}")
    public void  deleteItem(@PathVariable("basketId") final Integer basketId,
                        @RequestBody BasketData basketData,
                        @CookieValue("WC_SESSION") final String sid) {
        deletionService.deleteItem( sid, basketData );
    }
}
