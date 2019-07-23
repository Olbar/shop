package org.levelup.shop.service;



import org.levelup.shop.domain.dto.EntityData;
import org.levelup.shop.domain.dto.FileAsString;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface UserDetailsService {


    @Transactional
    void updateAvatarUserDetails(String sid, FileAsString fileAsString, EntityData entityData) throws IOException;
}
