package org.levelup.shop.service;



import org.levelup.shop.domain.dto.Item;
import org.levelup.shop.domain.dto.ItemData;

import java.util.Collection;


public interface ItemService {
    Collection<Item> findAll();

    Collection<Item> findAllItemsInCategory(Integer categoryId);

    Item findById(Integer itemId);

}
