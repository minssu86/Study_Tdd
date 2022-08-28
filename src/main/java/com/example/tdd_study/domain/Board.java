package com.example.tdd_study.domain;

import com.example.tdd_study.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 32)
    private String name;

    public Board(BoardRequestDto boardRequestDto) {
        this.name = boardRequestDto.getName();
    }
}
