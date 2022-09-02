package com.example.tdd_study.service;

import com.example.tdd_study.dto.MockArticleDto;
import com.example.tdd_study.dto.request.ArticleRequestDto;
import com.example.tdd_study.dto.response.ArticleResponseDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @DisplayName("입력")
    @Nested
    class ArticleServiceCreate{

        @DisplayName("성공 케이스")
        @Test
        void ArticleService_success() {

            // Given
            Integer board = 1;
            ArticleRequestDto articleRequestDto = new MockArticleDto(1);
            String location = "location 1";
            LocalDateTime createdDatetime = LocalDateTime.now();

            // When
            ArticleResponseDto result = articleService.create(board, articleRequestDto);

            // Then
            assertThat(result.getName()).isEqualTo("supercar");
            assertThat(result.getTitle()).isEqualTo(articleRequestDto.getTitle());
            assertThat(result.getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));
            assertThat(result.getLocation()).isEqualTo(location);

        }



        @DisplayName("실패 : 첨부 파일 위치")
        @Test
        void ArticleService_false() {

            // Given
            Integer board = 1;
            ArticleRequestDto articleRequestDto = new MockArticleDto(1);
            String location = "location 2";
            LocalDateTime createdDatetime = LocalDateTime.now();

            // When
            ArticleResponseDto result = articleService.create(board, articleRequestDto);

            // Then
            assertThat(result.getName()).isEqualTo("supercar");
            assertThat(result.getTitle()).isEqualTo(articleRequestDto.getTitle());
            assertThat(result.getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));
            assertThat(result.getLocation()).isNotEqualTo(location);

        }

    }

    @DisplayName("삭제")
    @Nested
    class ArticleServiceDelete{

        @BeforeEach
        void beforeEach(){

            for (int i = 1; i < 4; i++){
                ArticleRequestDto articleRequestDto = new MockArticleDto(i);
                articleService.create(i, articleRequestDto);
            }

        }

        @DisplayName("성공 케이스")
        @Test
        void ArticleService_success() {

            // Given
            Integer articleId = 1;

            // When
            String deleteSuccess = articleService.delete(articleId);
            List<ArticleResponseDto> results = articleService.getArticleDetailList();

            // Then
            assertThat(deleteSuccess).isEqualTo("삭제 성공");
            assertThat(results.get(0).getName()).isEqualTo("직수입");
            assertThat(results.get(0).getTitle()).isEqualTo("아티클 타이틀 2");
            assertThat(results.get(0).getAttachments().get(0).getLocation()).isEqualTo("location 6");
            assertThat(results.get(0).getAttachments().get(1).getLocation()).isEqualTo("location 4");
            assertThat(results.get(0).getAttachments().get(2).getLocation()).isEqualTo("location 2");

        }

    }

    @DisplayName("수정")
    @Nested
    class ArticleServiceUpdate{

        @BeforeEach
        void beforeEach(){

            for (int i = 1; i < 4; i++){
                ArticleRequestDto articleRequestDto = new MockArticleDto(i);
                articleService.create(i, articleRequestDto);
            }

        }

        @DisplayName("성공 케이스")
        @Test
        void ArticleService_success() {

            // Given
            Integer articleId = 1;
            ArticleRequestDto articleRequestDto = new MockArticleDto(2);

            // When
            String updateSuccess = articleService.update(articleId, articleRequestDto);
            List<ArticleResponseDto> results = articleService.getArticleDetailList();

            // Then
            assertThat(updateSuccess).isEqualTo("수정 성공");
            assertThat(results.get(0).getName()).isEqualTo("supercar");
            assertThat(results.get(0).getTitle()).isEqualTo("아티클 타이틀 2");
            assertThat(results.get(0).getContent()).isEqualTo("아티클 컨테트 2");
            assertThat(results.get(0).getAttachments().get(0).getLocation()).isEqualTo("location 3");
            assertThat(results.get(0).getAttachments().get(1).getLocation()).isEqualTo("location 2");
            assertThat(results.get(0).getAttachments().get(2).getLocation()).isEqualTo("location 1");

        }

    }

    @DisplayName("조회")
    @Nested
    class ArticleServiceSelect{

        @BeforeEach
        void beforeEach(){

            for (int i = 1; i < 4; i++){
                ArticleRequestDto articleRequestDto = new MockArticleDto(i);
                articleService.create(i, articleRequestDto);
            }

        }

        @DisplayName("성공 케이스")
        @Test
        void ArticleService_success() {
            // Given
            // When
            List<ArticleResponseDto> results = articleService.getArticleList();
            LocalDateTime createdDatetime = LocalDateTime.now();
            // Then
            assertThat(results.get(0).getName()).isEqualTo("supercar");
            assertThat(results.get(1).getName()).isEqualTo("직수입");
            assertThat(results.get(2).getName()).isEqualTo("커뮤니티");
            assertThat(results.get(0).getTitle()).isEqualTo("아티클 타이틀 1");
            assertThat(results.get(1).getTitle()).isEqualTo("아티클 타이틀 2");
            assertThat(results.get(2).getTitle()).isEqualTo("아티클 타이틀 3");
            assertThat(results.get(0).getCreatedDatetime()).isCloseTo(createdDatetime, within(5, ChronoUnit.SECONDS));
            assertThat(results.get(1).getCreatedDatetime()).isCloseTo(createdDatetime, within(5, ChronoUnit.SECONDS));
            assertThat(results.get(2).getCreatedDatetime()).isCloseTo(createdDatetime, within(5, ChronoUnit.SECONDS));
            assertThat(results.get(0).getLocation()).isEqualTo("location 1");
            assertThat(results.get(1).getLocation()).isEqualTo("location 2");
            assertThat(results.get(2).getLocation()).isEqualTo("location 3");

        }

        @DisplayName("성공 : 게시판 이름 검색")
        @Test
        void ArticleService_boardName_success() {
            // Given
            String boardName = "uper";
            // When
            List<ArticleResponseDto> results = articleService.getArticleListByBoardName(boardName);
            LocalDateTime createdDatetime = LocalDateTime.now();
            // Then
            assertThat(results.get(0).getName()).isEqualTo("supercar");
            assertThat(results.get(0).getTitle()).isEqualTo("아티클 타이틀 1");
            assertThat(results.get(0).getCreatedDatetime()).isCloseTo(createdDatetime, within(5, ChronoUnit.SECONDS));
            assertThat(results.get(0).getLocation()).isEqualTo("location 1");

        }

//        @DisplayName("성공 : 시작 날짜 검색")
//        @Test
//        void ArticleService_startDateTime_success() {
//            // Given
//            String boardName = "uper";
//            // When
//            List<ArticleResponseDto> results = articleService.getArticleListByBoardName(boardName);
//            LocalDateTime createdDatetime = LocalDateTime.now();
//            // Then
//            assertThat(results.get(0).getName()).isEqualTo("supercar");
//            assertThat(results.get(0).getTitle()).isEqualTo("아티클 타이틀 1");
//            assertThat(results.get(0).getCreatedDatetime()).isCloseTo(createdDatetime, within(5, ChronoUnit.SECONDS));
//            assertThat(results.get(0).getLocation()).isEqualTo("location 1");
//
//        }

        @DisplayName("성공 : 게시글 상세 조회")
        @Test
        void searchDetail_success() {

            // Given
            // When
            List<ArticleResponseDto> results = articleService.getArticleDetailList();
            LocalDateTime createdDatetime = LocalDateTime.now();
            // Then
            assertThat(results.get(0).getName()).isEqualTo("supercar");
            assertThat(results.get(0).getTitle()).isEqualTo("아티클 타이틀 1");
            assertThat(results.get(0).getCreatedDatetime()).isCloseTo(createdDatetime, within(5, ChronoUnit.SECONDS));
            assertThat(results.get(0).getAttachments().get(0).getLocation()).isEqualTo("location 3");
            assertThat(results.get(0).getAttachments().get(1).getLocation()).isEqualTo("location 2");
            assertThat(results.get(0).getAttachments().get(2).getLocation()).isEqualTo("location 1");
        }

    }
}

