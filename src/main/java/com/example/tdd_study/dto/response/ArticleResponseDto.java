package com.example.tdd_study.dto.response;

import com.example.tdd_study.domain.Article;
import com.example.tdd_study.domain.Attachment;
import com.example.tdd_study.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleResponseDto {

    private String name;
    private String title;
    private LocalDateTime createdDatetime;
    private String location;

    public ArticleResponseDto(Board board, Article article, Attachment attachment) {
        this.name = board.getName();
        this.title = article.getTitle();
        this.createdDatetime = article.getCreatedDatetime();
        this.location = attachment.getLocation();
    }
}
