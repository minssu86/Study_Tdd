package com.example.tdd_study.dto.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ArticleRequestDtoTest {

    @DisplayName("성공 : 입력값 반환")
    @Test
    void CreateArticleDtoSuccess() {

        // Given
        Integer boardId = 1;
        String title = "아티클 title";
        String content = "아티클 content";

        // When
        ArticleRequestDto articleRequestDto = new ArticleRequestDto();
        articleRequestDto.setBoardId(boardId);
        articleRequestDto.setTitle(title);
        articleRequestDto.setContent(content);

        // Then
        assertThat(articleRequestDto.getBoardId()).isEqualTo(boardId);
        assertThat(articleRequestDto.getTitle()).isEqualTo(title);
        assertThat(articleRequestDto.getContent()).isEqualTo(content);

    }

    @DisplayName("성공 : null")
    @Test
    void CreateArticleDtoSuccess2() {

        // Given
        Integer boardId = null;
        String title = null;
        String content = null;

        // When
        ArticleRequestDto articleRequestDto = new ArticleRequestDto();
        articleRequestDto.setBoardId(boardId);
        articleRequestDto.setTitle(title);
        articleRequestDto.setContent(content);

        // Then
        assertThat(articleRequestDto.getBoardId()).isNull();
        assertThat(articleRequestDto.getTitle()).isNull();
        assertThat(articleRequestDto.getContent()).isNull();

    }


}
