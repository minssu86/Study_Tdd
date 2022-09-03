package com.example.tdd_study.controller;

import com.example.tdd_study.dto.MockArticleDto;
import com.example.tdd_study.dto.MockArticleResponseDto;
import com.example.tdd_study.dto.request.ArticleRequestDto;
import com.example.tdd_study.dto.response.ArticleResponseDto;
import com.example.tdd_study.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArticleController.class)
//@AutoConfigureMockMvc
//@SpringBootTest
public class ArticleControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private WebApplicationContext ctx;

//    @Autowired
    @MockBean
    ArticleService articleService;

    @BeforeEach
    void beforeEach(){
        mvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @DisplayName("게시글 등록")
    @Nested
    class ArticleController_create{
        @Test
        @DisplayName("성공 : API 호출")
        void ArticleRequest_success() throws Exception {

            // Given
            String content = "{\"boardId\" : 1, \"title\" : \"아티클 타이틀 1\", \"content\" : \"아티클 컨테트 1\"}";
            String result = "{\"name\":\"supercar\",\"title\":\"아티클 타이틀 1\",\"location\":\"location 1\"}";
            // When
            // Then
            mvc.perform(post("/1/Article")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(content))
                        .andExpect(status().isOk())
                        .andExpect(content().json(result))
                        .andDo(print());

        }

    }

    @DisplayName("게시글 삭제")
    @Nested
    class ArticleController_delete{

        @BeforeEach
        void beforeEach(){

            for (int i = 1; i < 4; i++){
                ArticleRequestDto articleRequestDto = new MockArticleDto(i);
                articleService.create(i, articleRequestDto);
            }

        }

        @Test
        @DisplayName("성공 : 게시글 삭제")
        void ArticleRequest_success() throws Exception {

            // Given
            // When
            // Then
            mvc.perform(delete("/Article/1")
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8")
                            .content(""))
                            .andExpect(status().isOk())
                            .andExpect(content().string("삭제 성공"))
                            .andDo(print());

        }

    }

    @DisplayName("게시글 수정")
    @Nested
    class ArticleController_update{

        @BeforeEach
        void beforeEach(){

            for (int i = 1; i < 4; i++){
                ArticleRequestDto articleRequestDto = new MockArticleDto(i);
                articleService.create(i, articleRequestDto);
            }

        }

        @Test
        @DisplayName("성공 : 게시글 수정")
        void ArticleRequest_success() throws Exception {

            // Given
            String content = "{\"boardId\" : 1, \"title\" : \"아티클 타이틀 1\", \"content\" : \"아티클 컨테트 1\"}";
            // When
            // Then
            mvc.perform(put("/Article/1")
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8")
                            .content(content))
                    .andExpect(status().isOk())
                    .andExpect(content().string("수정 성공"))
                    .andDo(print());

        }

    }

    @DisplayName("게시글 조회")
    @Nested
    class ArticleController_select{

        @Test
        @DisplayName("성공 : 게시글 조회")
        void ArticleRequest_success() throws Exception {

            // Given
            String content = "[" +
                    "{\"name\":\"supercar\"," +
                    "\"title\":\"아티클 타이틀 1\"," +
                    "\"createdDatetime\":\"2022-09-01 12:00:00\"," +
                    "\"location\":\"location1\"},"+
                    "{\"name\":\"supercar\"," +
                    "\"title\":\"아티클 타이틀 2\"," +
                    "\"createdDatetime\":\"2022-09-01 13:00:00\"," +
                    "\"location\":\"location2\"}" +
                    "]";
            List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();

            articleResponseDtos.add(new MockArticleResponseDto(
                    "supercar", "아티클 타이틀 1", "2022-09-01 12:00:00", "location1"));
            articleResponseDtos.add(new MockArticleResponseDto(
                    "supercar", "아티클 타이틀 2", "2022-09-01 13:00:00", "location2"));
            // When
            when(articleService.getArticleList()).thenReturn(articleResponseDtos);
            // Then
            mvc.perform(get("/Article")
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8")
                            .content(""))
                    .andExpect(status().isOk())
                    .andExpect(content().string(content))
                    .andDo(print());
        }

    }


}







