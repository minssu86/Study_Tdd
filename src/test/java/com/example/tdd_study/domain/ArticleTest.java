package com.example.tdd_study.domain;

import com.example.tdd_study.dto.ArticleRequestDto;
import com.example.tdd_study.dto.MockArticleDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.*;

public class ArticleTest {

    @DisplayName("성공 : 입력값 반환")
    @Test
    void CreateArticleSuccess() {

        // Given
        ArticleRequestDto articleRequestDto = new MockArticleDto(1);
        LocalDateTime createdDatetime = LocalDateTime.now();

        // When
        Article article = new Article(articleRequestDto);

        // Then
        assertThat(article.getBoardId()).isEqualTo(articleRequestDto.getBoardId());
        assertThat(article.getTitle()).isEqualTo(articleRequestDto.getTitle());
        assertThat(article.getContent()).isEqualTo(articleRequestDto.getContent());
        assertThat(article.getViewCount()).isEqualTo(articleRequestDto.getViewCount());
        assertThat(article.getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));

    }



}
