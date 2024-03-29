package org.levelup.shop.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    @Column(name = "first_name")
    private String firstName;

    @OneToOne(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private UserDetailsEntity details;

}
