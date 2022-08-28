package com.example.tdd_study.dto;

public class MockBoardDto extends BoardRequestDto {

    public MockBoardDto(int testCase){
        if(testCase == 1){
            super.setName("보드 네임 1");
        }else if(testCase == 2){
            super.setName("보드 네임 2");
        } else if (testCase == 3) {
            super.setName("보드 네임 3");
        }
    }

}
