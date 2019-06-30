package org.levelup.shop.service.impl;



import org.levelup.shop.domain.entity.AuthSessionEntity;
import org.levelup.shop.domain.entity.UserEntity;
import org.levelup.shop.domain.dto.UserSession;
import org.levelup.shop.repository.AuthorizationSessionRepository;
import org.levelup.shop.repository.UserRepository;
import org.levelup.shop.service.AuthorizationSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthorizationSessionServiceImpl implements AuthorizationSessionService {
    private final UserRepository userRepository;
    private final AuthorizationSessionRepository authSessionRepository;

    @Autowired
    public AuthorizationSessionServiceImpl(UserRepository userRepository,
                                           AuthorizationSessionRepository authSessionRepository) {
        this.userRepository = userRepository;
        this.authSessionRepository = authSessionRepository;
    }

    @Override
    public UserSession createOrUpdateSession(String login) {
        UserEntity user = userRepository.findByLogin(login);
        if (user == null) {
            throw new RuntimeException();
        }

        Optional<AuthSessionEntity> possibleSession = authSessionRepository.findByLogin(login);
        LocalDateTime expiredDate = LocalDateTime.now().plusDays(1);

        if (possibleSession.isPresent()) {
            AuthSessionEntity entity = possibleSession.get();
            entity.setExpiredDate(expiredDate);
            authSessionRepository.save(entity);

            return new UserSession(entity.getSid(), expiredDate, entity.getUser().getLogin());
        }

        AuthSessionEntity entity = new AuthSessionEntity();
        entity.setUser(user);
        entity.setExpiredDate(expiredDate);
        authSessionRepository.save(entity);

        return new UserSession(entity.getSid(), expiredDate, entity.getUser().getLogin());
    }

    @Override
    public boolean isExpired(String sid) {
        return authSessionRepository.findById(sid) // Optional<AuthSessionEntity>
                .map(session -> session.getExpiredDate().isBefore(LocalDateTime.now())) // if session not null
                .orElse(true);  // if session - null
    }

}
