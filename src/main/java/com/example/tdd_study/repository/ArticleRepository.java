package com.example.tdd_study.repository;

import com.example.tdd_study.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByBoardId(Integer id);
}
