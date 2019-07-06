package org.levelup.shop.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "auth_sessions")
public class AuthSessionEntity {



    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String sid;

    @Column(name = "expired_date")
    private LocalDateTime expiredDate;

    @OneToOne
    private UserEntity user;

}


