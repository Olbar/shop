package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.Basket;
import org.levelup.shop.domain.dto.Item;
import org.levelup.shop.domain.dto.User;
import org.levelup.shop.domain.entity.BasketEntity;
import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.exception.ShopException;
import org.levelup.shop.repository.BasketRepository;
import org.levelup.shop.service.BasketService;
import org.levelup.shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class BasketServiceImpl extends AbstractService implements BasketService {

    private final BasketRepository basketRepository;
    private final UserService userService;

    @Autowired
    public BasketServiceImpl(ModelMapper modelMapper, BasketRepository basketRepository, UserService userService) {
        super( modelMapper );
        this.basketRepository = basketRepository;
        this.userService = userService;
    }

    @Override
    public Collection<Basket> findAll() {
        Iterable<BasketEntity> values = basketRepository.findAll();
        return findAllEntities( values, Basket.class );
    }

    @Override
    public Collection<Basket> findAllItemsByUserId(Integer userId) {
        Iterable<BasketEntity> values= basketRepository.findByUserId( userId );
        return findAllEntities( values, Basket.class );
    }

    @Override
    public Basket findById(Integer basketId) {
        return basketRepository.findById( basketId )
                .map( entity -> modelMapper.map( entity, Basket.class ) )
                .orElseThrow( ShopException::new );
    }

}
