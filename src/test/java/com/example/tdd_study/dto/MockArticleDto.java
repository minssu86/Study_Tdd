package com.example.tdd_study.dto;

import com.example.tdd_study.dto.request.ArticleRequestDto;

public class MockArticleDto extends ArticleRequestDto {

    public MockArticleDto(int testCase){
        if(testCase == 1){
            super.setBoardId(1);
            super.setTitle("아티클 타이틀 1");
            super.setContent("아티클 컨테트 1");
        }else if(testCase == 2){
            super.setBoardId(2);
            super.setTitle("아티클 타이틀 2");
            super.setContent("아티클 컨테트 2");
        } else if (testCase == 3) {
            super.setBoardId(3);
            super.setTitle("아티클 타이틀 3");
            super.setContent("아티클 컨테트 3");
        }
    }

}
