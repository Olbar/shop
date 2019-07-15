package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.Basket;
import org.levelup.shop.domain.entity.BasketEntity;
import org.levelup.shop.repository.BasketRepository;
import org.levelup.shop.service.BasketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class BasketServiceImpl extends AbstractService implements BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketServiceImpl(ModelMapper modelMapper, BasketRepository basketRepository) {
        super( modelMapper );
        this.basketRepository = basketRepository;
    }

    @Override
    public Collection<Basket> findAll() {
        Iterable<BasketEntity> values = basketRepository.findAll();
        return findAllEntities( values, Basket.class );
    }
}
