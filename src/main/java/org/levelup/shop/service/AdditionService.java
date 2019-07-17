package org.levelup.shop.service;

import org.levelup.shop.domain.dto.Basket;
import org.levelup.shop.domain.dto.ItemData;

public interface AdditionService {

    Basket addItem(String sid, ItemData itemData);
}
