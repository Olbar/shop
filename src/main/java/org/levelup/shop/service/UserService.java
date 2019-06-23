package org.levelup.shop.service;

import org.levelup.shop.domain.entity.dto.User;

import java.util.Collection;

public interface UserService {

    Collection<User> getAll();

    boolean auth(String login, String password);
}
