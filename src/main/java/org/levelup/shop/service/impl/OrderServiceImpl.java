package org.levelup.shop.service.impl;


import org.levelup.shop.domain.dto.Order;
import org.levelup.shop.domain.entity.OrderEntity;
import org.levelup.shop.repository.OrderRepository;
import org.levelup.shop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderServiceImpl extends AbstractService implements OrderService {


    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(ModelMapper modelMapper, OrderRepository orderRepository) {
        super(modelMapper);
        this.orderRepository = orderRepository;
    }

    @Override
    public Collection<Order> findAllOrdersForUser(Integer userId) {
        Iterable<OrderEntity> values = orderRepository.findByUserId( userId );
        return findAllEntities( values, Order.class );
    }
}
