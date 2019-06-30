package org.levelup.shop.service;

import org.levelup.shop.domain.dto.Item;

import java.util.Collection;


public interface ShopService {
    Collection<Item> getAll();

}
