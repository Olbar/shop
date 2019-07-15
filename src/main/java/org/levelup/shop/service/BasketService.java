package org.levelup.shop.service;


import org.levelup.shop.domain.dto.Basket;

import java.util.Collection;

public interface BasketService {

    Collection<Basket> findAll();

}
