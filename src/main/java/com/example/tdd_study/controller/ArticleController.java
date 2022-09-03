package com.example.tdd_study.controller;

import com.example.tdd_study.dto.request.ArticleRequestDto;
import com.example.tdd_study.dto.response.ArticleResponseDto;
import com.example.tdd_study.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/{boardId}/Article")
    public ArticleResponseDto create(@PathVariable Integer boardId, @RequestBody ArticleRequestDto articleRequestDto){
        return articleService.create(boardId, articleRequestDto);
    }

    @DeleteMapping("/Article/{articleId}")
    public String delete(@PathVariable Integer articleId){
        return articleService.delete(articleId);
    }

    @PutMapping("/Article/{articleId}")
    public String update(@PathVariable Integer articleId, @RequestBody ArticleRequestDto articleRequestDto){
        return articleService.update(articleId, articleRequestDto);
    }

    @GetMapping("/Article")
    public List<ArticleResponseDto> getArticleList(){
        return articleService.getArticleList();
    }



}
