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
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String article_number;
    private Double price;
    private Integer count;
    private Integer category_id;

    @ManyToOne
    @JoinColumn(name = "category_id",insertable = false, updatable = false)
    private CategoryEntity category;

    public ItemEntity(String name, String article_number, Double price, Integer count, Integer category_id, CategoryEntity category) {
        this.name = name;
        this.article_number = article_number;
        this.price = price;
        this.count = count;
        this.category_id = category_id;
        this.category = category;
    }
}
