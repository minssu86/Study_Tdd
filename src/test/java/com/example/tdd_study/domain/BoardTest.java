package com.example.tdd_study.domain;


import com.example.tdd_study.dto.BoardRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class BoardTest {
    // id : integer  (pk)
    // name : varchar(32)

    @DisplayName("성공: 입렵값 반환")
    @Test
    void CreateBoard_Success() {
        // Given
        String name = "가나다라마";

        BoardRequestDto boardRequestDto = new BoardRequestDto();
        boardRequestDto.setName(name);

        // When
        Board board = new Board(boardRequestDto);

        // Then
        assertThat(board.getName()).isEqualTo(name);
    }

}
