package org.levelup.shop.service;


import org.levelup.shop.domain.dto.CheckoutRequest;
import org.springframework.transaction.annotation.Transactional;

public interface CheckoutService {

    @Transactional
    void checkout(String sid, CheckoutRequest request);
}
