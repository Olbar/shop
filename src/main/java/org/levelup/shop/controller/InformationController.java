package org.levelup.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InformationController {


    @GetMapping("/about")
    public String cabinetPage(Model model) {
        return "about";
    }
}
