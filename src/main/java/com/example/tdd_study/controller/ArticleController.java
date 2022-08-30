package com.example.tdd_study.controller;

import com.example.tdd_study.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ArticleController {

    private ArticleService articleService;

    @PostMapping("/{board}/Article")
    public String create(@PathVariable String board){
        log.info("board Num : {}", board);
        return "hello";
    }

}
