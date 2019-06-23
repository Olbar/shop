package org.levelup.shop.repository;


import org.levelup.shop.domain.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {

    ItemEntity findByName(String name);
}
