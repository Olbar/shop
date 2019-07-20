package org.levelup.shop.service;


import org.levelup.shop.domain.dto.BasketData;

public interface DeletionService {

    void deleteItem(String sid, BasketData basketData);
}
