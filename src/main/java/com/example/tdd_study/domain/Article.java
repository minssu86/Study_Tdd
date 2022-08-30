package com.example.tdd_study.domain;

import com.example.tdd_study.dto.request.ArticleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(length = 128)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private Integer viewCount;

    @Column(name = "created_datatime")
    private LocalDateTime createdDatetime;

    public Article(Board board, ArticleRequestDto articleRequestDto){
        this.board = board;
        this.title = articleRequestDto.getTitle();
        this.content = articleRequestDto.getContent();
        this.viewCount = 0;
        this.createdDatetime = LocalDateTime.now();
    }

    public void update(ArticleRequestDto articleRequestDto){
        this.title = articleRequestDto.getTitle();
        this.content = articleRequestDto.getContent();
    }

}
