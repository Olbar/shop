package org.levelup.shop.service;

import org.levelup.shop.domain.dto.Item;

import java.util.Collection;


public interface ItemService {
    Collection<Item> findAllItemsInCategory(Integer categoryId);

}
