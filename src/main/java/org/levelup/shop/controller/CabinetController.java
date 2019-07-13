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
    @Value("${shop.attachments}")

    private String attachmentDirectoryPath;

    private final AuthorizationSessionService authSessionService;
    private final UserService userService;


    @Autowired
    public CabinetController(AuthorizationSessionService authSessionService, UserService userService) {
        this.authSessionService = authSessionService;
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping("/string")
    public void loadImageAsString(@RequestBody FileAsString fileAsString) throws IOException {
        byte[] bytes = Base64.getDecoder().decode(fileAsString.getFile());
        File file = new File(attachmentDirectoryPath + fileAsString.getFilename());

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
