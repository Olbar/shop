package org.levelup.shop.controller;





import org.levelup.shop.domain.dto.FileAsString;

import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Base64;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {
    @Value("${shop.attachments.avatars}")
    private String avatarsDirectoryPath;

    private final AuthorizationSessionService authSessionService;
    private final UserService userService;


    @Autowired
    public CabinetController(AuthorizationSessionService authSessionService, UserService userService) {
        this.authSessionService = authSessionService;
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping("/string")
    public void loadImageAsString(@RequestBody FileAsString fileAsString,
                                  @CookieValue("WC_SESSION") final String sid) throws IOException {
        byte[] bytes = Base64.getDecoder().decode(fileAsString.getFile());
        String userLogin=authSessionService.findLoginBySessionId( sid );
        System.out.println("dsjhfkjdsf:"+ avatarsDirectoryPath + userLogin+"/"+fileAsString.getFilename());
        File file = new File(avatarsDirectoryPath + userLogin+"/"+fileAsString.getFilename());

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(bytes);
            outputStream.flush();
        }
    }



    @GetMapping
    public  String displayCabinet(@CookieValue("WC_SESSION") final String sid, Model model){
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        model.addAttribute( "user", userService.findById( userId ));
        model.addAttribute( "user_details", userService.findUserDetailsById( userId ) );
        return "cabinet";
    }



}
