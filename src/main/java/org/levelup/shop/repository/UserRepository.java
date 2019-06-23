package org.levelup.shop.repository;


import org.levelup.shop.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

 UserEntity findByLogin(String login);

}
