package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.RegistrationRequest;
import org.levelup.shop.domain.entity.UserDetailsEntity;
import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.repository.UserDetailsRepository;
import org.levelup.shop.repository.UserRepository;
import org.levelup.shop.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    @Transactional
    public void register(RegistrationRequest request) {
        UserEntity user = new UserEntity();
        user.setFirstName(request.getPassword());
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());

        UserEntity entity = userRepository.save(user);

        UserDetailsEntity details = new UserDetailsEntity();
        details.setFirstName(request.getFirstName());
        details.setLastName(request.getLastName());
        details.setAge(request.getAge());
        details.setId(entity.getId());
        details.setUser(entity);

        userDetailsRepository.save(details);
    }

}