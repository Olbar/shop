package org.levelup.shop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    public BasketEntity(Integer user_id, Integer itemId, String article_number, Double price) {
        this.user_id = user_id;
        this.itemId = itemId;
        this.article_number = article_number;
        this.price = price;
    }
}
