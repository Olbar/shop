package org.levelup.shop.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Array;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class CheckoutEntity {

    @Id
    private Integer id;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "delivery_method")
    private String deliveryMethod;
    private Integer user_id;
    private Array itemId;
    private String phone;
    private String address;


    @OneToOne
    @JoinColumn(name = "id")
    private UserEntity user;
}
