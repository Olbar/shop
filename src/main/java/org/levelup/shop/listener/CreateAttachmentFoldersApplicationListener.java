package org.levelup.shop.listener;

import lombok.SneakyThrows;
import org.levelup.shop.domain.dto.User;
import org.levelup.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class CreateAttachmentFoldersApplicationListener implements ApplicationListener<ContextRefreshedEvent>{
    @Value("${shop.attachments}")
    private String attachmentsPath;
    @Value("${shop.attachments.avatars}")
    private String avatarPath;

    private final UserService userService;

    @Autowired
    public CreateAttachmentFoldersApplicationListener(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        boolean attachmentsFolderExist = Files.exists( Paths.get(attachmentsPath));
        boolean avatarsFolderExist = Files.exists(Paths.get(avatarPath));

        if (!attachmentsFolderExist) {
            createFolder(attachmentsPath);
        }
        if (!avatarsFolderExist) {
            createFolder(avatarPath);
        }
        for (User user : userService.getAll()) {
            if (!Files.exists(Paths.get(attachmentsPath + user.getLogin()))) {
                Files.createDirectory(Paths.get(attachmentsPath + user.getLogin()));
            }
        }
    }

    @SneakyThrows
    private void createFolder(String path) {
        Files.createDirectories(Paths.get(path));
    }
}
