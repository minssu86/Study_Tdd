package com.example.tdd_study.dto;

public class MockAttachmentDto extends AttachmentRequestDto {

    public MockAttachmentDto(int testCase){
        if(testCase == 1){
            super.setArticleId(1);
            super.setLocation("location 1");
        }else if(testCase == 2){
            super.setArticleId(2);
            super.setLocation("location 2");
        } else if (testCase == 3) {
            super.setArticleId(3);
            super.setLocation("location 3");
        }
    }


}
