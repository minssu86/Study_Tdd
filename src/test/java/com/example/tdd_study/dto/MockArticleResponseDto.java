package com.example.tdd_study.dto;

import com.example.tdd_study.dto.response.ArticleResponseDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MockArticleResponseDto extends ArticleResponseDto {

    public MockArticleResponseDto(String name, String title, String createdDatetime, String location){
        super.setName(name);
        super.setTitle(title);
        super.setCreatedDatetime(LocalDateTime.parse(createdDatetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        super.setLocation(location);

    }

}
