package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.Cabinet;
import org.levelup.shop.domain.dto.Item;
import org.levelup.shop.domain.dto.User;
import org.levelup.shop.exception.ShopException;
import org.levelup.shop.repository.CabinetRepository;
import org.levelup.shop.repository.UserRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.CabinetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CabinetServiceImpl extends AbstractService implements CabinetService {

    private final AuthorizationSessionService authSessionService;
    private final UserRepository userRepository;
    private final CabinetRepository cabinetRepository;


    @Autowired
    public CabinetServiceImpl(ModelMapper modelMapper, AuthorizationSessionService authSessionService, UserRepository userRepository, CabinetRepository cabinetRepository) {
        super(modelMapper);
        this.authSessionService = authSessionService;
        this.userRepository = userRepository;
        this.cabinetRepository = cabinetRepository;
    }

    @Override
    public Cabinet findById(Integer userId) {
        return cabinetRepository.findById(userId)
                .map( entity -> modelMapper.map( entity, Cabinet.class ) )
                .orElseThrow( ShopException::new );
    }
}
