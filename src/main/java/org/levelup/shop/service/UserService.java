package org.levelup.shop.service;


import org.levelup.shop.domain.dto.User;

import java.util.Collection;

public interface UserService {

    Collection<User> findAll();

    User findById(Integer userId);

    boolean auth(String login, String password);
}
