package org.levelup.shop.service;


import org.levelup.shop.domain.dto.Feedback;

import java.util.Collection;

public interface FeedbackService {

    Collection<Feedback> findAllFeedbacksForItem(Integer itemId);


}
