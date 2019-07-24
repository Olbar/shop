package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.*;
import org.levelup.shop.domain.entity.FeedbackEntity;
import org.levelup.shop.domain.entity.ItemEntity;
import org.levelup.shop.domain.entity.UserDetailsEntity;
import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.repository.FeedbackRepository;
import org.levelup.shop.repository.ItemRepository;
import org.levelup.shop.repository.UserDetailsRepository;
import org.levelup.shop.repository.UserRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.levelup.shop.service.FeedbackService;
import org.levelup.shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl extends AbstractService implements FeedbackService {

    private final AuthorizationSessionService authSessionService;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final FeedbackRepository feedbackRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final UserService userService;


    @Autowired
    protected FeedbackServiceImpl(ModelMapper modelMapper, AuthorizationSessionService authSessionService,
                                  UserRepository userRepository, ItemRepository itemRepository, FeedbackRepository feedbackRepository, UserDetailsRepository userDetailsRepository, UserService userService) {
        super( modelMapper );
        this.authSessionService = authSessionService;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.feedbackRepository = feedbackRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.userService = userService;
    }

    @Override
    @Transactional
    public Collection<Feedback> findAllFeedbacksForItem(Integer itemId) {
        Iterable<FeedbackEntity> values = feedbackRepository.findByItemId( itemId );
        Collection<Feedback> allEntities = findAllEntities( values, Feedback.class );
        Iterator<FeedbackEntity> iterator = values.iterator();
        return allEntities.stream()
                .peek( entity -> entity.setUser( new UserAvatar( "/avatars/default.png", iterator.next().getAuthor().getFirstName()) ) )
                .collect( Collectors.toList() );
    }

//iterator.next().getAuthor().getDetails().getAvatarPath()
    @Override
    @Transactional
    public Feedback saveFeedback(String sid, FeedbackData feedbackData) {
        String login = authSessionService.findLoginBySessionId( sid );
        UserEntity user = userRepository.findByLogin( login );
        Integer userId = authSessionService.findUserIdBySessionId(sid);
        UserDetailsEntity userDetails=userDetailsRepository.findByUserId(userId);
        ItemEntity item = itemRepository.findById( feedbackData.getItemId() ).get();
        FeedbackEntity result = feedbackRepository.save( new FeedbackEntity( feedbackData.getText(), LocalDateTime.now(), user, item ) );
        return new Feedback( result.getId(), result.getText(), new UserAvatar(userDetails.getAvatarPath(), user.getFirstName()));
    }



}
