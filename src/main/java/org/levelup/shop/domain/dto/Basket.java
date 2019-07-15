package org.levelup.shop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    private Integer id;
    private Integer userId;
    private Integer itemId;
    private String article_number;
    private Double price;
}
