package com.example.tdd_study.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BoardRequestDtoTest {

    @DisplayName("성공: 입렵값 반환")
    @Test
    void CreateBoardDtoSuccess() {

        // Given
        String name = "게시판 이름";

        // When
        BoardRequestDto boardRequestDto = new BoardRequestDto();
        boardRequestDto.setName(name);

        // Then
        assertThat(boardRequestDto.getName()).isEqualTo(name);

    }

    @DisplayName("성공 : null")
    @Test
    void CreateBoardDtoSuccess2() {

        // Given
        String name = null;

        // When
        BoardRequestDto boardRequestDto = new BoardRequestDto();
        boardRequestDto.setName(name);

        // Then
        assertThat(boardRequestDto.getName()).isNull();
    }

}
