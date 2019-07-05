package org.levelup.shop.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@NoArgsConstructor
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
}
