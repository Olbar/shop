package org.levelup.shop.controller;

import org.levelup.shop.domain.dto.RegistrationRequest;
import org.levelup.shop.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String displayRegistrationPath(Model model) {
        model.addAttribute("request", new RegistrationRequest());
        return "registration";
    }

    @PostMapping
    public String registerAndRedirectToLogin(@ModelAttribute("request") final RegistrationRequest request) {
        registrationService.register(request);
        return "redirect:/login";
    }

}
