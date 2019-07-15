package org.levelup.shop.repository;


import org.levelup.shop.domain.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Integer> {

      @Query(
              value = "select u.first_name, f.text from users u " +
                      "join feedbacks f on u.id=f.author_id " +
                      "where f.item_id=:item_id",
              nativeQuery = true
      )
      Iterable<FeedbackEntity> findAuthorByItemId(@Param( "item_id" ) Integer feedbackId);
      Iterable<FeedbackEntity> findByItemId(Integer itemId);

}
