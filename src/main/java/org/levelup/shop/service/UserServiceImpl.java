package org.levelup.shop.service;


import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.domain.entity.dto.User;
import org.levelup.shop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<User> getAll() {
        Iterable<UserEntity> iterable = userRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(),false).map(entity->modelMapper.map(entity, User.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean auth(String login, String password) {
        return false;
    }
}
