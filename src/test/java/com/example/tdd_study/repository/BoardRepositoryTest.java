package com.example.tdd_study.repository;

import com.example.tdd_study.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @DisplayName("성공 : 조회")
    @Test
    void BoardRepo_success() {

        // Ginve
//        INSERT INTO board VALUES(1,'supercar');
//        INSERT INTO board VALUES(2,'직수입');
//        INSERT INTO board VALUES(3,'커뮤니티');
//        INSERT INTO board VALUES(4,'문의');
//        INSERT INTO board VALUES(5,'제휴업체');

        // When
        Board board = boardRepository.findById(1).orElseThrow(
                    ()-> new NullPointerException("DB에 데이터 없음")
                );

        // Then
        assertThat(board.getId()).isEqualTo(1);
        assertThat(board.getName()).isEqualTo("supercar");
        assertThat(boardRepository.count()).isEqualTo(5);

    }
}
