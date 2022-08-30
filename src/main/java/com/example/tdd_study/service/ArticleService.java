package com.example.tdd_study.service;

import com.example.tdd_study.dto.request.ArticleRequestDto;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    public String create(Integer board, ArticleRequestDto articleRequestDto) {
        return "성공";
    }
}
