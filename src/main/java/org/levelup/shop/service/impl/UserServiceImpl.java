package org.levelup.shop.service.impl;


import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.domain.dto.User;
import org.levelup.shop.repository.UserRepository;
import org.levelup.shop.service.AuthenticationService;
import org.levelup.shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(AuthenticationService authenticationService, UserRepository userRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<User> getAll() {
        Iterable<UserEntity> iterable = userRepository.findAll();
        return findAllEntities(iterable,User.class);
    }


    @Override
    public boolean auth(String login, String password) {
        return authenticationService.authenticate(login, password);
    }


}
