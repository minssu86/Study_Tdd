package com.example.tdd_study.dto.response;

import com.example.tdd_study.domain.Article;
import com.example.tdd_study.domain.Attachment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleResponseDto {

    private String name;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDatetime;
    private String location;
    private List<Attachment> attachments;

    public ArticleResponseDto(Article article, Attachment attachment) {
        this.name = article.getBoard().getName();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdDatetime = article.getCreatedDatetime();
        this.location = attachment.getLocation();
    }

    public ArticleResponseDto(Article article, List<Attachment> attachments) {
        this.name = article.getBoard().getName();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdDatetime = article.getCreatedDatetime();
        this.attachments = attachments;
    }

}
