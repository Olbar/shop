package org.levelup.shop.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {

    private String sid;
    private LocalDateTime expiredDate;
    private String login;

}
