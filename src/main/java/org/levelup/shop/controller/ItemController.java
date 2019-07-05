package org.levelup.shop.controller;


import org.levelup.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String displayAllItems(Model model) {
        model.addAttribute("items", itemService.findAllItemsInCategory());
        return "items";
    }
}
*/