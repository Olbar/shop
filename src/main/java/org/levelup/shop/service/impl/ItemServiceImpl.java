package org.levelup.shop.service.impl;

import org.levelup.shop.domain.entity.ItemEntity;
import org.levelup.shop.domain.dto.Item;
import org.levelup.shop.repository.ItemRepository;
import org.levelup.shop.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServiceImpl extends AbstractService implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper) {
        super(modelMapper);
        this.itemRepository = itemRepository;
    }

    @Override
    public Collection<Item> findAllItemsInCategory(Integer categoryId) {
        Iterable<ItemEntity> values = itemRepository.findByCategoryId(categoryId);
        return findAllEntities(values, Item.class);
    }

}
