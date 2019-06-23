package org.levelup.shop.service;

import org.levelup.shop.domain.entity.dto.Item;

import java.util.Collection;


public interface ShopService {
    Collection<Item> getAll();

}
