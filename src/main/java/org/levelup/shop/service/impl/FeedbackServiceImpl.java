package org.levelup.shop.service.impl;

import org.levelup.shop.domain.dto.Feedback;
import org.levelup.shop.domain.entity.FeedbackEntity;
import org.levelup.shop.repository.FeedbackRepository;
import org.levelup.shop.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FeedbackServiceImpl extends AbstractService implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    protected FeedbackServiceImpl(ModelMapper modelMapper, FeedbackRepository feedbackRepository) {
        super( modelMapper );
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Collection<Feedback> findAllFeedbacksForItem(Integer itemId) {
        Iterable<FeedbackEntity> values = feedbackRepository.findByItemId(itemId);
        return findAllEntities(values, Feedback.class);
    }
}
