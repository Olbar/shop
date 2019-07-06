package org.levelup.shop.service;


import org.levelup.shop.domain.dto.Feedback;
import org.levelup.shop.domain.dto.FeedbackData;

import java.util.Collection;

public interface FeedbackService {

    Collection<Feedback> findAllFeedbacksForItem(Integer itemId);
    void saveFeedback(String sid, FeedbackData feedbackData);

}
