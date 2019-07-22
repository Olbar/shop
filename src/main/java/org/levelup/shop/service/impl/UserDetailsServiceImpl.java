package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.FileAsString;
import org.levelup.shop.domain.entity.UserDetailsEntity;
import org.levelup.shop.repository.UserDetailsRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.UserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthorizationSessionService authSessionService;
    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(AuthorizationSessionService authSessionService, UserDetailsRepository userDetailsRepository) {
        this.authSessionService = authSessionService;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    @Transactional
    public void updateAvatarUserDetails(String sid, FileAsString fileAsString, UserDetailsEntity userDetailsEntity, String avatarsDirectoryPath) throws IOException {
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        String userLogin=authSessionService.findLoginBySessionId( sid );
        UserDetailsEntity user = userDetailsRepository.findByUserId(userId);
        user.setFirstName(userDetailsEntity.getFirstName());
        user.setLastName( userDetailsEntity.getLastName() );
        byte[] bytes = Base64.getDecoder().decode(fileAsString.getFile());
        String avatarPath=avatarsDirectoryPath + userLogin+"/"+fileAsString.getFilename();
        File file = new File(avatarsDirectoryPath + userLogin+"/"+fileAsString.getFilename());

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(bytes);
            outputStream.flush();
        }
        user.setAvatarPath( avatarPath );
        user.setAge( userDetailsEntity.getAge() );
        user.setAvatarPath( avatarPath );
        user.setAge( userDetailsEntity.getAge() );
        userDetailsRepository.save(user);

    }
}
