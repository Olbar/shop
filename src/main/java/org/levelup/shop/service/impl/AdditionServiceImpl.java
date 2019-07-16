package org.levelup.shop.service.impl;


import org.levelup.shop.domain.dto.Item;
import org.levelup.shop.domain.dto.ItemData;
import org.levelup.shop.domain.dto.User;
import org.levelup.shop.domain.entity.BasketEntity;
import org.levelup.shop.repository.BasketRepository;
import org.levelup.shop.service.AdditionService;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.ItemService;
import org.levelup.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdditionServiceImpl implements AdditionService {

    private final BasketRepository basketRepository;
    private final AuthorizationSessionService authSessionService;
    private final ItemService itemService;
    private final UserService userService;

    @Autowired
    public AdditionServiceImpl(BasketRepository basketRepository, AuthorizationSessionService authSessionService, ItemService itemService, UserService userService) {
        this.basketRepository = basketRepository;
        this.authSessionService = authSessionService;
        this.itemService = itemService;
        this.userService = userService;
    }


    @Override
    @Transactional
    public void addItem(String sid, Integer itemId) {
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        Item entity = itemService.findById( itemId );
        User uentity= userService.findById( userId );
        BasketEntity basket =new BasketEntity( );

        basket.setArticle_number( entity.getArticle_number() );
        basket.setPrice( entity.getPrice() );
        basket.setItemId( entity.getId() );
        basket.setUser_id( uentity.getId() );

        basketRepository.save(basket);
    }


}
