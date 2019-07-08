package org.levelup.shop.repository;

import org.levelup.shop.domain.entity.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity, Integer> {
}
