package org.levelup.shop.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    private Integer id;
    private String name;
    private boolean active;

    public CategoryEntity() {
        this.active = true;
    }




}
