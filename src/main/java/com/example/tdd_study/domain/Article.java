package com.example.tdd_study.domain;

import com.example.tdd_study.dto.ArticleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "board_id")
    private Integer boardId;

    @Column(length = 128)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private Integer viewCount;

    @Column(name = "created_datatime")
    private LocalDateTime createdDatetime;

    public Article(ArticleRequestDto articleRequestDto){
        this.boardId = articleRequestDto.getBoardId();
        this.title = articleRequestDto.getTitle();
        this.content = articleRequestDto.getContent();
        this.viewCount = articleRequestDto.getViewCount();
        this.createdDatetime = LocalDateTime.now();
    }

}
