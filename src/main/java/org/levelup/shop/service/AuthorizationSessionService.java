package org.levelup.shop.service;


import org.levelup.shop.domain.dto.UserSession;

public interface AuthorizationSessionService {


    UserSession createOrUpdateSession(String login);

    boolean isExpired(String sid);
}
