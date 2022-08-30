package com.example.tdd_study.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArticleRequestDto {

    private Integer boardId;
    private String title;
    private String content;

}
