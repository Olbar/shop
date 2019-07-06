package org.levelup.shop.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "feedbacks")
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;

    @Column(name = "send_date")
    private LocalDateTime sendDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;


    @ManyToOne
    @JoinColumn(name = "item_id",updatable = false)
    private ItemEntity item;

    public FeedbackEntity(String text, LocalDateTime sendDate, UserEntity author, ItemEntity item) {
        this.text = text;
        this.sendDate = sendDate;
        this.author = author;
        this.item = item;
    }
}

