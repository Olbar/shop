package org.levelup.shop.controller;




import org.levelup.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CabinetController {

    private final UserService userService;

    @Autowired
    public CabinetController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/cabinet")
    public String cabinetPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "cabinet";
    }

}
