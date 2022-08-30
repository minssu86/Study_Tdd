package com.example.tdd_study.service;

import com.example.tdd_study.dto.MockArticleDto;
import com.example.tdd_study.dto.request.ArticleRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleServiceTest {

    @DisplayName("입력")
    @Nested
    class ArticleServiceCreate{

        @DisplayName("성공 케이스")
        @Test
        void ArticleService_success() {

            // Given
            Integer board = 1;
            ArticleRequestDto articleRequestDto = new MockArticleDto(1);
            ArticleService articleService = new ArticleService();

            // When
            String result = articleService.create(board, articleRequestDto);

            // Then
            assertThat(result).isEqualTo("성공");

        }
    }


}
