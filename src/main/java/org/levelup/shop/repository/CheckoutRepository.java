package org.levelup.shop.repository;


import org.levelup.shop.domain.entity.CheckoutEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository  extends CrudRepository<CheckoutEntity, Integer> {
}
