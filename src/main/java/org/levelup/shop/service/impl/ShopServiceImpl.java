package org.levelup.shop.service.impl;

import org.levelup.shop.domain.entity.ItemEntity;
import org.levelup.shop.domain.dto.Item;
import org.levelup.shop.repository.ItemRepository;
import org.levelup.shop.service.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShopServiceImpl implements ShopService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShopServiceImpl(ItemRepository itemRepository,ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<Item> getAll() {
        Iterable<ItemEntity> iterable = itemRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(),false).map(entity->modelMapper.map(entity, Item.class))
                .collect(Collectors.toList());
    }
}
