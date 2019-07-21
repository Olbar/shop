package org.levelup.shop.service;



import org.levelup.shop.domain.dto.Order;

import java.util.Collection;

public interface OrderService {

    Collection<Order> findAllOrdersForUser(Integer userId);
}
