package com.example.tdd_study.domain;

import com.example.tdd_study.dto.MockArticleDto;
import com.example.tdd_study.dto.request.ArticleRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.*;


public class AttachmentTest {

    @DisplayName("성공 : 입력값 반환")
    @Test
    void CreateAttachmentSuccess() {

        // Given
        String location = "location 1";
        ArticleRequestDto articleRequestDto = new MockArticleDto(1);
        Board board = new Board();
        Article article = new Article(board, articleRequestDto);
        LocalDateTime createdDatetime = LocalDateTime.now();

        // When
        Attachment attachment = new Attachment(article, location);

        // Then
        assertThat(attachment.getId()).isEqualTo(null);
        assertThat(attachment.getArticle().getId()).isEqualTo(null);
        assertThat(attachment.getArticle().getBoard().getId()).isEqualTo(null);
        assertThat(attachment.getArticle().getBoard().getName()).isEqualTo(null);
        assertThat(attachment.getArticle().getTitle()).isEqualTo(articleRequestDto.getTitle());
        assertThat(attachment.getArticle().getContent()).isEqualTo(articleRequestDto.getContent());
        assertThat(attachment.getArticle().getViewCount()).isEqualTo(0);
        assertThat(attachment.getArticle().getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));
        assertThat(attachment.getLocation()).isEqualTo(location);
        assertThat(attachment.getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));

    }

}
