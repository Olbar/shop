package org.levelup.shop.repository;

import org.levelup.shop.domain.entity.BasketEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<BasketEntity, Integer> {

}
