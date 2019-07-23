package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.EntityData;
import org.levelup.shop.domain.dto.FileAsString;
import org.levelup.shop.domain.dto.UserDetails;
import org.levelup.shop.domain.entity.UserDetailsEntity;
import org.levelup.shop.exception.ShopException;
import org.levelup.shop.repository.UserDetailsRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.UserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class UserDetailsServiceImpl extends AbstractService implements UserDetailsService {

    @Value("${shop.attachments.avatars}")
    private String avatarsDirectoryPath;

    private final AuthorizationSessionService authSessionService;
    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(AuthorizationSessionService authSessionService, UserDetailsRepository userDetailsRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.authSessionService = authSessionService;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    @Transactional
    public void updateAvatarUserDetails(String sid, FileAsString fileAsString, EntityData entityData) throws IOException {
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        String userLogin=authSessionService.findLoginBySessionId( sid );
        UserDetailsEntity oldUser= userDetailsRepository.findByUserId(entityData.getUserId());
        UserDetailsEntity user = userDetailsRepository.findByUserId(userId);
        user.setFirstName(oldUser.getFirstName());
        user.setLastName( oldUser.getLastName() );
        String avatarPath=avatarsDirectoryPath + userLogin+"/"+fileAsString.getFilename();
        user.setAvatarPath( avatarPath );
        user.setAge( oldUser.getAge() );
        user.setAvatarPath( avatarPath );
        user.setAge( oldUser.getAge() );
        userDetailsRepository.save(user);

    }


    @Override
    public UserDetails findUserDetailsById(Integer userId) {
        return userDetailsRepository.findById( userId )
                .map( entity -> modelMapper.map( entity, UserDetails.class ) )
                .orElseThrow( ShopException::new );
    }
}
