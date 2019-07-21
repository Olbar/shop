package org.levelup.shop.service.impl;


import org.levelup.shop.domain.dto.Basket;
import org.levelup.shop.domain.dto.CheckoutRequest;


import org.levelup.shop.domain.entity.OrderEntity;
import org.levelup.shop.repository.OrderRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.BasketService;
import org.levelup.shop.service.CheckoutService;
import org.levelup.shop.service.GetTotalValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final BasketService basketService;
    private final AuthorizationSessionService authSessionService;
    private final OrderRepository orderRepository;
    private final GetTotalValuesService getTotalValuesService;

    @Autowired
    public CheckoutServiceImpl(BasketService basketService, AuthorizationSessionService authSessionService, OrderRepository orderRepository, GetTotalValuesService getTotalValuesService) {
        this.basketService = basketService;
        this.authSessionService = authSessionService;
        this.orderRepository = orderRepository;
        this.getTotalValuesService = getTotalValuesService;
    }


    @Override
    @Transactional
    public void checkout(String sid, CheckoutRequest request) {
        OrderEntity order = new OrderEntity();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM");
        String formatDateTime = now.format(formatter);
        Double totalPrice=getTotalValuesService.getTotalPrice( sid );

        Integer userId = authSessionService.findUserIdBySessionId(sid);
        order.setUser_id( userId );
        Collection<Basket> baskets= basketService.findAllBasketsByUserId(userId);
      //  String[] itemIds = baskets.stream().map(Basket::getItemId).collect(Collectors.toList()).toArray(new Integer[0]);


      //  Integer[] itemIds = baskets.stream().map(Basket::getItemId).collect(Collectors.toList()).toArray(new Integer[0]);
        //[1,2,3,4,6]

     //   Integer[] itemIds = new Integer[baskets.size()];
       //int i = 0;
       // for (Basket basket: baskets) {
       //     itemIds[i] = basket.getItemId();
      //        i++;
     //    }
        //[1,2,3,4,6]

        String itemIds = baskets.stream().map(Basket::getItemId).map(String::valueOf).collect(Collectors.joining(","));
        //"1,2,3,4,5"

        order.setItemIds(itemIds);
        order.setAddress( request.getAddress() );
        order.setPhone( request.getPhone() );
        order.setDeliveryMethod( request.getDeliveryMethod() );
        order.setPaymentMethod( request.getPaymentMethod() );
        order.setTotalPrice( totalPrice );
        order.setDateTime( LocalDateTime.from( formatter.parse(formatDateTime) ) );

        orderRepository.save( order );
    }
}
