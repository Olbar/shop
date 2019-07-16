package org.levelup.shop.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "basket")
public class BasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id;
    private Integer itemId;
    private String article_number;
    private Double price;

    @OneToOne
    @JoinColumn(name = "user_id", updatable = false,insertable = false)
    private UserEntity user;
}
