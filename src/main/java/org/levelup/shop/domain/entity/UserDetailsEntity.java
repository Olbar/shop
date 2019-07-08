package org.levelup.shop.domain.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_details")
public class UserDetailsEntity {


    @Id
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "avatar_path")
    private String avatarPath;
    private Integer age;

    @OneToOne
    @JoinColumn(name = "id")
    private UserEntity user;

}
