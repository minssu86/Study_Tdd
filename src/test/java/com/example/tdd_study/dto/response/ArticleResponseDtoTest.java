package com.example.tdd_study.dto.response;

import com.example.tdd_study.domain.Article;
import com.example.tdd_study.domain.Attachment;
import com.example.tdd_study.domain.Board;
import com.example.tdd_study.dto.MockArticleDto;
import com.example.tdd_study.dto.request.ArticleRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class ArticleResponseDtoTest {

    @DisplayName("성공 : 입력값 반환")
    @Test
    void ArticleResponseDto_success() {

        // Given
        ArticleRequestDto articleRequestDto = new MockArticleDto(1);
        Board board = new Board();
        Article article = new Article(board, articleRequestDto);
        LocalDateTime createdDatetime = LocalDateTime.now();
        Attachment attachment = new Attachment();

        // When
        ArticleResponseDto articleResponseDto = new ArticleResponseDto(article, attachment);

        // Then
        assertThat(articleResponseDto.getName()).isEqualTo(board.getName());
        assertThat(articleResponseDto.getTitle()).isEqualTo(articleRequestDto.getTitle());
        assertThat(articleResponseDto.getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));
        assertThat(articleResponseDto.getLocation()).isEqualTo(attachment.getLocation());
    }
}
