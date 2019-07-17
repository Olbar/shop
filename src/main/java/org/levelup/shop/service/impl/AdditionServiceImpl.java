package org.levelup.shop.service.impl;


import org.levelup.shop.domain.dto.*;
import org.levelup.shop.domain.entity.BasketEntity;
import org.levelup.shop.domain.entity.ItemEntity;
import org.levelup.shop.repository.BasketRepository;
import org.levelup.shop.repository.ItemRepository;
import org.levelup.shop.service.AdditionService;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.ItemService;
import org.levelup.shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdditionServiceImpl extends AbstractService implements AdditionService {

    private final BasketRepository basketRepository;
    private final AuthorizationSessionService authSessionService;
    private final ItemService itemService;
    private final UserService userService;
    private final ItemRepository itemRepository;

    @Autowired
    public AdditionServiceImpl(ModelMapper modelMapper, BasketRepository basketRepository, AuthorizationSessionService authSessionService, ItemService itemService, UserService userService, ItemRepository itemRepository) {
        super( modelMapper );
        this.basketRepository = basketRepository;
        this.authSessionService = authSessionService;
        this.itemService = itemService;
        this.userService = userService;
        this.itemRepository = itemRepository;
    }


    @Override
    @Transactional
    public Basket addItem(String sid, ItemData itemData) {
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        ItemEntity entity = itemRepository.findById( itemData.getItemId() ).get();
        User uentity= userService.findById( userId );

        BasketEntity result= basketRepository.save( new BasketEntity( entity.getId(),uentity.getId(),entity.getArticle_number(),entity.getPrice()));
      return new Basket(result.getId(),result.getUser_id(),result.getItemId(),result.getArticle_number(),result.getPrice());
    }

}
