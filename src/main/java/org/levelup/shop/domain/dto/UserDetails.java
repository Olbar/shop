package org.levelup.shop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
    private String login;
    private String avatarPath;
}
