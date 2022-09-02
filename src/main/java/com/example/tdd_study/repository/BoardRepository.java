package com.example.tdd_study.repository;

import com.example.tdd_study.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByNameContains(String boardName);
}
