package org.levelup.shop.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name= "feedbacks")
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String text;

    @Column(name = "send_date")
    private LocalDateTime sendDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;


    @ManyToOne
    @JoinColumn(name = "item_id",insertable = false, updatable = false)
    private ItemEntity item;
}

