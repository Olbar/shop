package org.levelup.shop.repository;

import org.levelup.shop.domain.entity.AuthSessionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizationSessionRepository extends CrudRepository<AuthSessionEntity, String> {
    @Query(
            value = "select * from auth_sessions s " +
                    "join users u on s.user_id = u.id " +
                    "where u.login = :login",
            nativeQuery = true
    )
    Optional<AuthSessionEntity> findByLogin(@Param("login") String login);
    Optional<AuthSessionEntity> findBySid(String sid);
}
