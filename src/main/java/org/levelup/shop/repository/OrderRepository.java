package org.levelup.shop.repository;




import org.levelup.shop.domain.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends CrudRepository<OrderEntity, Integer> {

    Iterable<OrderEntity> findByUserId(Integer userId);
}
