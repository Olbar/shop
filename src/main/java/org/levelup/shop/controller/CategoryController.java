package org.levelup.shop.controller;


import org.levelup.shop.service.CategoryService;
import org.levelup.shop.service.GetTotalValuesService;
import org.levelup.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final ItemService itemService;
    private final GetTotalValuesService getTotalValuesService;

    @Autowired
    public CategoryController(CategoryService categoryService, ItemService itemService, GetTotalValuesService getTotalValuesService) {
        this.categoryService = categoryService;
        this.itemService = itemService;
        this.getTotalValuesService = getTotalValuesService;
    }

    @GetMapping
    public String displayCategories(Model model) {
        model.addAttribute( "categories", categoryService.findAll() );
        return "categories";
    }

    @GetMapping("/{categoryId}")//path parameter
    public  String displayCategory(@PathVariable("categoryId") final Integer categoryId,
                                   @CookieValue("WC_SESSION") final String sid, Model model){
        model.addAttribute( "category", categoryService.findById(categoryId));
        model.addAttribute( "items",itemService.findAllItemsInCategory( categoryId ));
        model.addAttribute( "total", getTotalValuesService.getTotalPrice( sid ));
        return "category-by-id";
    }

}
