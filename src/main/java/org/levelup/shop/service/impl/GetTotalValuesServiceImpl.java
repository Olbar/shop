package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.Basket;
import org.levelup.shop.service.BasketService;
import org.modelmapper.ModelMapper;
import org.levelup.shop.domain.dto.TotalBasketValues;
import org.levelup.shop.repository.BasketRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.GetTotalValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class GetTotalValuesServiceImpl  implements GetTotalValuesService {

    private final AuthorizationSessionService authSessionService;
    private final BasketRepository basketRepository;
    private final BasketService basketService;

    @Autowired
    public GetTotalValuesServiceImpl(AuthorizationSessionService authSessionService, BasketRepository basketRepository, ModelMapper modelMapper, BasketService basketService) {
        this.authSessionService = authSessionService;
        this.basketRepository = basketRepository;
        this.basketService = basketService;
    }

    @Override
    public Double getValues(String sid) {
        Integer userId=authSessionService.findUserIdBySessionId( sid );
        basketRepository.findTotalPriceByUserId( userId );
        return new TotalBasketValues().getTotal();
    }

    @Override
    public Double getTotalPrice(String sid){
        Integer userId=authSessionService.findUserIdBySessionId( sid );
        Collection<Basket> results =  basketService.findAllBasketsByUserId( userId );
        Double[] prices = new Double[results.size()];
        int i = 0;
        double total=0;
        for (Basket result: results) {
          prices[i] = result.getPrice();
            total=total+prices[i];
                i++;
            }
        return total;
        }
    }

