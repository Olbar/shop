package org.levelup.shop.domain.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
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



    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}


