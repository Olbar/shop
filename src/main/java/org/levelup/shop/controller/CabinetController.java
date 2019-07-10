package org.levelup.shop.controller;




import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CabinetController {

    private final AuthorizationSessionService authSessionService;
    private final UserService userService;


    @Autowired
    public CabinetController(AuthorizationSessionService authSessionService, UserService userService) {
        this.authSessionService = authSessionService;
        this.userService = userService;
    }


    @GetMapping("/cabinet")
    public  String displayCabinet(@CookieValue("WC_SESSION") final String sid, Model model){
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        model.addAttribute( "user", userService.findById( userId ));
        return "cabinet";
    }

}
