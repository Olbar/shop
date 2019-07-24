package org.levelup.shop.service;



import org.levelup.shop.domain.dto.EntityData;
import org.levelup.shop.domain.dto.FileAsString;

import org.levelup.shop.domain.dto.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Collection;

public interface UserDetailsService {


    @Transactional
    void updateAvatarUserDetails(String sid, FileAsString fileAsString, EntityData entityData) throws IOException;

    UserDetails findUserDetailsById(Integer userId);
     Collection<UserDetails> findAll();
}
