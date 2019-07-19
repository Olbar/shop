package org.levelup.shop.service.impl;


import org.levelup.shop.domain.dto.Basket;
import org.levelup.shop.domain.dto.CheckoutRequest;

import org.levelup.shop.domain.entity.CheckoutEntity;

import org.levelup.shop.repository.CheckoutRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.BasketService;
import org.levelup.shop.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final BasketService basketService;
    private final AuthorizationSessionService authSessionService;
    private final CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutServiceImpl(BasketService basketService, AuthorizationSessionService authSessionService, CheckoutRepository checkoutRepository) {
        this.basketService = basketService;
        this.authSessionService = authSessionService;
        this.checkoutRepository = checkoutRepository;
    }


    @Override
    @Transactional
    public void checkout(String sid, CheckoutRequest request) {
        CheckoutEntity order = new CheckoutEntity();
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        order.setUser_id( userId );
        Collection<Basket> baskets= basketService.findAllItemsByUserId(userId);
        Integer[] itemIds = baskets.stream().map(Basket::getItemId).collect(Collectors.toList()).toArray(new Integer[0]);
        //[1,2,3,4,6]

        Integer[] itemIds2 = new Integer[baskets.size()];
        int i = 0;
        for (Basket basket: baskets) {
            itemIds2[i] = basket.getItemId();
            i++;
        }
        //[1,2,3,4,6]

        String items3 = baskets.stream().map(Basket::getItemId).map(String::valueOf).collect(Collectors.joining(","));
        //"1,2,3,4,6999"




        order.setAddress( request.getAddress() );
        order.setPhone( request.getPhone() );
        order.setDeliveryMethod( request.getDeliveryMethod() );
        order.setPaymentMethod( request.getPaymentMethod() );
        checkoutRepository.save( order );
    }
}
