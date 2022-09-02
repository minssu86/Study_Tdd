package com.example.tdd_study.repository;

import com.example.tdd_study.domain.Article;
import com.example.tdd_study.domain.Attachment;
import com.example.tdd_study.domain.Board;
import com.example.tdd_study.dto.MockArticleDto;
import com.example.tdd_study.dto.request.ArticleRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@DataJpaTest
public class AttachmentRepositoryTest {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ArticleRepository articleRepository;

    @DisplayName("성공 : 입력")
    @Test
    void AttachmentRepo_success() {

        // Given
        Board board = boardRepository.findById(1).orElseThrow(
                ()-> new NullPointerException("보드 데이터 없음")
        );
        ArticleRequestDto articleRequestDto = new MockArticleDto(1);
        Article article = new Article(board, articleRequestDto);
        articleRepository.save(article);
        String location = "location 1";
        Attachment attachment = new Attachment(article, location);
        attachmentRepository.save(attachment);
        LocalDateTime createdDatetime = LocalDateTime.now();

        // When
        Attachment result = attachmentRepository.findById(1).orElseThrow(
                ()-> new NullPointerException("어테치 데이터 없음")
        );

        // Then
        assertThat(result).isSameAs(attachment);
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getArticle()).isSameAs(article);
        assertThat(result.getLocation()).isEqualTo(location);
        assertThat(result.getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));


    }
}
