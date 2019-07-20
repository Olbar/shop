package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.BasketData;
import org.levelup.shop.repository.BasketRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.DeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeletionServiceImpl implements DeletionService {

    private final BasketRepository basketRepository;
    private final AuthorizationSessionService authSessionService;

    @Autowired
    public DeletionServiceImpl(BasketRepository basketRepository, AuthorizationSessionService authSessionService) {
        this.basketRepository = basketRepository;
        this.authSessionService = authSessionService;
    }

    @Override
    @Transactional
    public void deleteItem(String sid, BasketData basketData) {
        basketRepository.deleteById(basketData.getBasketId());
    }
}
