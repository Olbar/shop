package org.levelup.shop.repository;

import org.levelup.shop.domain.dto.TotalBasketValues;
import org.levelup.shop.domain.entity.BasketEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<BasketEntity, Integer> {
    Iterable<BasketEntity> findByUserId(Integer userId);

    @Query(
            value = "select SUM(price) as total from basket b where b.user_id=:vasya",
            nativeQuery = true
    )
    TotalBasketValues findTotalPriceByUserId(@Param( "vasya" ) Integer userId);
}
