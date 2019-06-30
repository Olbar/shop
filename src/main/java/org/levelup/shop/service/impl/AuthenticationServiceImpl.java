package org.levelup.shop.service.impl;


import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.repository.UserRepository;
import org.levelup.shop.service.AuthenticationService;
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
        return entity != null && entity.getPassword().equals(password);
    }
}
