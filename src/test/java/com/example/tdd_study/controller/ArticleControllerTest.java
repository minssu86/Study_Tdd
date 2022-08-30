package com.example.tdd_study.controller;

import com.example.tdd_study.service.ArticleServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArticleController.class)
//@AutoConfigureMockMvc
//@SpringBootTest
public class ArticleControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private ArticleServiceTest articleServiceTest;

    @DisplayName("게시글 등록")
    @Nested
    class ArticleController_create{
        @Test
        @DisplayName("성공 : API 호출")
        void ArticleRequest_success() throws Exception {

            // Given
            String hello = "hello";

            // When
            ResultActions resultActions = mvc.perform(post("/1/Article")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(""));
            // Then
            resultActions
                    .andExpect(status().isOk())
                    .andExpect(content().string(hello))
                    .andDo(print());
        }

    }

}







