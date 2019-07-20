package org.levelup.shop.service;


import org.levelup.shop.domain.dto.Basket;
import org.levelup.shop.domain.dto.Item;

import java.util.Collection;

public interface BasketService {

    Collection<Basket> findAll();

    Collection<Basket> findAllBasketsByUserId(Integer userId);

    Basket findById(Integer basketId);
}
