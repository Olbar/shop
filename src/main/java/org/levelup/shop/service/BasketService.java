package org.levelup.shop.service;


import org.levelup.shop.domain.dto.Basket;

import java.util.Collection;
import java.util.List;

public interface BasketService {

    Collection<Basket> findAll();

    Collection<Basket> findAllItemsByUserId(Integer userId);

    Basket findById(Integer basketId);
}
