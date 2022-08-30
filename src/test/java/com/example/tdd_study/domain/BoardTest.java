//package com.example.tdd_study.domain;
//
//
//import com.example.tdd_study.repository.BoardRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.*;
//
//@SpringBootTest
//public class BoardTest {
//    // id : integer  (pk)
//    // name : varchar(32)
//    BoardRepository boardRepository;
//    public BoardTest(BoardRepository boardRepository){
//        this.boardRepository = boardRepository;
//    }
//
//    @DisplayName("성공: DB데이터 부르기")
//    @Test
//    void CreateBoard_Success() {
//        // Given
//        Integer id = 1;
//
//        // When
//        Board board = boardRepository.findById(id).orElse(null);
//
//        // Then
//        assertThat(board.getName()).isEqualTo("supercar");
//    }
//
//}
