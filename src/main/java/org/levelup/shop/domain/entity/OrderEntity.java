package org.levelup.shop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity {

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
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "date")
    private LocalDateTime dateTime;


    @OneToOne
    @JoinColumn(name = "user_id",updatable = false,insertable = false)
    private UserEntity user;
}
