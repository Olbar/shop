package org.levelup.shop.service;


import org.levelup.shop.domain.dto.Cabinet;
import org.levelup.shop.domain.dto.User;
import org.springframework.stereotype.Service;

import java.util.Collection;



public interface CabinetService {

    Cabinet findById(Integer userId);

}
