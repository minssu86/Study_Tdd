package com.example.tdd_study.dto;

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
        Integer viewCount = 1;

        // When
        ArticleRequestDto articleRequestDto = new ArticleRequestDto();
        articleRequestDto.setBoardId(boardId);
        articleRequestDto.setTitle(title);
        articleRequestDto.setContent(content);
        articleRequestDto.setViewCount(viewCount);

        // Then
        assertThat(articleRequestDto.getBoardId()).isEqualTo(boardId);
        assertThat(articleRequestDto.getTitle()).isEqualTo(title);
        assertThat(articleRequestDto.getContent()).isEqualTo(content);
        assertThat(articleRequestDto.getViewCount()).isEqualTo(viewCount);

    }

    @DisplayName("성공 : null")
    @Test
    void CreateArticleDtoSuccess2() {

        // Given
        Integer boardId = null;
        String title = null;
        String content = null;
        Integer viewCount = null;

        // When
        ArticleRequestDto articleRequestDto = new ArticleRequestDto();
        articleRequestDto.setBoardId(boardId);
        articleRequestDto.setTitle(title);
        articleRequestDto.setContent(content);
        articleRequestDto.setViewCount(viewCount);

        // Then
        assertThat(articleRequestDto.getBoardId()).isNull();
        assertThat(articleRequestDto.getTitle()).isNull();
        assertThat(articleRequestDto.getContent()).isNull();
        assertThat(articleRequestDto.getViewCount()).isNull();

    }


}



//        LocalDateTime.parse("2022-08-27 22:30:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//    @DisplayName("실패 : title 글자수 제한")
//    @Test
//    void CreateArticleDtoFalse() {
//
//        // Given
//        Integer boardId = 1;
//        String title = "일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사오육칠팔구십" +
//                "일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사오육칠팔구십" +
//                "일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사오육칠팔구"; // 129자
//        String content = "아티클 content";
//        Integer viewCount = 1;
//        String createdDatetime = "2022-08-27 22:30:30";
//
//        // When
//        ArticleRequestDto articleRequestDto = new ArticleRequestDto();
//        articleRequestDto.setBoardId(boardId);
//        articleRequestDto.setContent(content);
//        articleRequestDto.setViewCount(viewCount);
//        articleRequestDto.setCreatedDatetime(createdDatetime);
//
//        // Then
//        assertThat(articleRequestDto.getBoardId()).isEqualTo(boardId);
//        assertThatThrownBy(()->{
//            // When
//            articleRequestDto.setTitle(title);
//        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("글자수 제한");
//        assertThat(articleRequestDto.getContent()).isEqualTo(content);
//        assertThat(articleRequestDto.getViewCount()).isEqualTo(viewCount);
//        assertThat(articleRequestDto.getCreatedDatetime()).isEqualTo(createdDatetime);
//
//    }
//
//    @DisplayName("실패 : content 글자수 제한")
//    @Test
//    void CreateArticleDtoFalse2() {
//
//        // Given
//        Integer boardId = 1;
//        String title = "아티클 title"; // 129자
//        StringBuilder makeContent = new StringBuilder();
//        makeContent.append("가");
//        while (makeContent.length()<21844){
//            makeContent.append("가");
//        }
//        String content = makeContent.toString();
//        Integer viewCount = 1;
//        String createdDatetime = "2022-08-27 22:30:30";
//
//
//        // When
//        ArticleRequestDto articleRequestDto = new ArticleRequestDto();
//        articleRequestDto.setBoardId(boardId);
//        articleRequestDto.setTitle(title);
//        articleRequestDto.setViewCount(viewCount);
//        articleRequestDto.setCreatedDatetime(createdDatetime);
//
//        // Then
//        assertThat(articleRequestDto.getBoardId()).isEqualTo(boardId);
//        assertThat(articleRequestDto.getTitle()).isEqualTo(title);
//        assertThatThrownBy(()->{
//            // When
//            articleRequestDto.setContent(content);
//        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("글자수 제한");
//        assertThat(articleRequestDto.getViewCount()).isEqualTo(viewCount);
//        assertThat(articleRequestDto.getCreatedDatetime()).isEqualTo(createdDatetime);
//
//    }