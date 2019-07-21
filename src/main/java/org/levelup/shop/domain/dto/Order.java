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
public class Order {

    private Integer id;
    private Integer userId;
    private String itemIds;
    private String address;
    private String phone;
    private String paymentMethod;
    private String deliveryMethod;
    private Double totalPrice;
    private LocalDateTime dateTime;
}
