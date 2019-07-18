package org.levelup.shop.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CheckoutRequest {

    private String address;
    private String phone;
    private String paymentMethod;
    private String deliveryMethod;

}
