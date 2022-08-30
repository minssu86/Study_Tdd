package com.example.tdd_study.repository;

import com.example.tdd_study.domain.Article;
import com.example.tdd_study.domain.Board;
import com.example.tdd_study.dto.MockArticleDto;
import com.example.tdd_study.dto.request.ArticleRequestDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    BoardRepository boardRepository;

    @DisplayName("성공 : 입력")
    @Test
    void articleRepo_success() {

        // Given
        Board board = boardRepository.findById(1).orElseThrow(
                ()-> new NullPointerException("데이터 없음")
        );
        ArticleRequestDto articleRequestDto = new MockArticleDto(1);
        Article article = new Article(board, articleRequestDto);
        LocalDateTime createdDatetime = LocalDateTime.now();

        // When
        Article result = articleRepository.save(article);

        // Then
        assertThat(result).isSameAs(article);
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getBoard().getId()).isEqualTo(board.getId());
        assertThat(result.getBoard().getName()).isEqualTo(board.getName());
        assertThat(result.getTitle()).isEqualTo(articleRequestDto.getTitle());
        assertThat(result.getContent()).isEqualTo(articleRequestDto.getContent());
        assertThat(result.getViewCount()).isEqualTo(0);
        assertThat(result.getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));

    }

}
