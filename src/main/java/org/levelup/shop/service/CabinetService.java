package org.levelup.shop.service;


import org.levelup.shop.domain.dto.Cabinet;
import org.springframework.stereotype.Service;


@Service
public interface CabinetService {

    Cabinet findById(Integer userId);
}
