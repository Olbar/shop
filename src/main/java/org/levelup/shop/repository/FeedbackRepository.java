package org.levelup.shop.repository;

import org.levelup.shop.domain.entity.FeedbackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Integer> {

      Iterable<FeedbackEntity> findByItemId(Integer itenId);
}

