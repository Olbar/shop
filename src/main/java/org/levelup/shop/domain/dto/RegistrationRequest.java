package org.levelup.shop.domain.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegistrationRequest {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;

}
