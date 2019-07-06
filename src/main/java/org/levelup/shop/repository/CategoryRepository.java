package org.levelup.shop.repository;

import org.levelup.shop.domain.entity.CategoryEntity;
import org.levelup.shop.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer>{
    CategoryEntity findByName(String name);
}
