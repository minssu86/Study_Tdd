package com.example.tdd_study.repository;

import com.example.tdd_study.dto.BoardRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @DisplayName("성공 : 데이터 저장")
    @Test
    void BoardRepositorySuccess() {

        // Given
        Integer id = 1;
        String name = "가나다라마";
        BoardRequestDto boardRequestDto = new BoardRequestDto();

        // When


        // Then

    }
}
