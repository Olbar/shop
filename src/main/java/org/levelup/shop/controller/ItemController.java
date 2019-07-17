package org.levelup.shop.controller;


import org.levelup.shop.domain.dto.FeedbackData;
import org.levelup.shop.domain.dto.ItemData;
import org.levelup.shop.service.AdditionService;
import org.levelup.shop.service.FeedbackService;
import org.levelup.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final FeedbackService feedbackService;
    private final AdditionService additionService;

    @Autowired
    public ItemController(FeedbackService feedbackService, ItemService itemService, AdditionService additionService) {
        this.feedbackService = feedbackService;
        this.itemService = itemService;
        this.additionService = additionService;
    }

    @GetMapping
    public String displayItems(Model model) {
        model.addAttribute( "items", itemService.findAll() );
        return "items";
    }

    @GetMapping("/{itemId}")//path parameter
    public  String displayFeedback(@PathVariable("itemId") final Integer itemId, Model model){
        model.addAttribute( "item", itemService.findById(itemId));
        model.addAttribute( "feedbacks",feedbackService.findAllFeedbacksForItem(itemId));
        return "item-by-id";
    }


    @PostMapping("/{itemId}/feedback")
    public void saveFeedback(@PathVariable final Integer itemId,
                             @RequestBody FeedbackData feedbackData,
                             @CookieValue("WC_SESSION") final String sid) {
        feedbackService.saveFeedback( sid, feedbackData );

    }

    @ResponseBody
    @PostMapping("/{itemId}/basket")
    public void addItem(@PathVariable final Integer itemId,
                        @RequestBody ItemData itemData,
                        @CookieValue("WC_SESSION") final String sid) {
        additionService.addItem( sid, itemData );
    }
}
