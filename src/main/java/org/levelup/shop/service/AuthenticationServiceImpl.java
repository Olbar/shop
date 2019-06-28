package org.levelup.shop.service;

import org.levelup.shop.AuthenticationException;
import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public boolean authenticate(String login, String password)  {
        UserEntity entity = userRepository.findByLogin(login);
        if (entity != null && entity.getPassword().equals(password)) {
            return true;
        }
            return false;
       // throw new AuthenticationException();
    }
}
