package org.levelup.shop.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class CheckoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "delivery_method")
    private String deliveryMethod;
    private Integer user_id;

    @Column(name = "item_ids")
    private String itemIds;
    private String phone;
    private String address;


    @OneToOne
    @JoinColumn(name = "id")
    private UserEntity user;
}
