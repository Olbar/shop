package org.levelup.shop.controller;





import org.levelup.shop.domain.dto.EntityData;
import org.levelup.shop.domain.dto.FileAsString;

import org.levelup.shop.domain.entity.UserDetailsEntity;
import org.levelup.shop.repository.UserDetailsRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.UserDetailsService;
import org.levelup.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Base64;

@Controller

public class CabinetController {
    @Value("${shop.attachments.avatars}")
    private String avatarsDirectoryPath;

    private final AuthorizationSessionService authSessionService;
    private final UserService userService;
    private final UserDetailsRepository userDetailsRepository;
    private final UserDetailsService userDetailsService;

    @Autowired
    public CabinetController(AuthorizationSessionService authSessionService, UserService userService, UserDetailsRepository userDetailsRepository, UserDetailsService userDetailsService) {
        this.authSessionService = authSessionService;
        this.userService = userService;
        this.userDetailsRepository = userDetailsRepository;
        this.userDetailsService = userDetailsService;
    }

    @ResponseBody
    @PostMapping("/cabinet/string")
    public void loadImageAsString(@RequestBody FileAsString fileAsString,
                                  @CookieValue("WC_SESSION") final String sid) throws IOException {
        String userLogin=authSessionService.findLoginBySessionId( sid );
        byte[] bytes = Base64.getDecoder().decode(fileAsString.getFile());
        System.out.println("lalala:"+ avatarsDirectoryPath + userLogin+"/"+fileAsString.getFilename());
        File file = new File(avatarsDirectoryPath + userLogin+"/"+fileAsString.getFilename());

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(bytes);
            outputStream.flush();
        }
    }

   @ResponseBody
   @PutMapping("/user_details/{userId}")
public String changeUserAvatar(@RequestBody FileAsString fileAsString,
                             @CookieValue("WC_SESSION") final String sid,
                               EntityData entityData) throws IOException {
      userDetailsService.updateAvatarUserDetails( sid, fileAsString, entityData);
       return "cabinet";
   }

    @GetMapping("/cabinet")
    public  String displayCabinet(@CookieValue("WC_SESSION") final String sid, Model model){
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        model.addAttribute( "user", userService.findById( userId ));
        model.addAttribute( "user_details", userService.findUserDetailsById( userId ) );
        return "cabinet";
    }



}
