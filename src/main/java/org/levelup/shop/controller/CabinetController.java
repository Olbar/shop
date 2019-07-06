package org.levelup.shop.controller;



import org.levelup.shop.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CabinetController {

    private final CabinetService cabinetService;

    @Autowired
    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }



    @GetMapping("/cabinet")
    public String cabinetPage(Model model) {
        return "cabinet";
    }

}
