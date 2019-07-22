package org.levelup.shop.service;



import org.levelup.shop.domain.dto.FileAsString;
import org.levelup.shop.domain.entity.UserDetailsEntity;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface UserDetailsService {


    @Transactional
    void updateAvatarUserDetails(String sid, FileAsString fileAsString, UserDetailsEntity userDetailsEntity, String avatarsDirectoryPath) throws IOException;
}
