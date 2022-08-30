package com.example.tdd_study.dto.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AttachmentRequestDtoTest {

    @DisplayName("성공 : 입력값 반환")
    @Test
    void CreateAttachmentDtoSuccess() {

        // Given
        Integer articleId = 1;
        String location = "부산";

        // When
        AttachmentRequestDto attachmentRequestDto = new AttachmentRequestDto();
        attachmentRequestDto.setArticleId(articleId);
        attachmentRequestDto.setLocation(location);

        // Then
        assertThat(attachmentRequestDto.getArticleId()).isEqualTo(articleId);
        assertThat(attachmentRequestDto.getLocation()).isEqualTo(location);

    }

    @DisplayName("성공 : null")
    @Test
    void CreateAttachmentDtoSuccess2() {

        // Given
        Integer articleId = null;
        String location = null;

        // When
        AttachmentRequestDto attachmentRequestDto = new AttachmentRequestDto();
        attachmentRequestDto.setArticleId(articleId);
        attachmentRequestDto.setLocation(location);

        // Then
        assertThat(attachmentRequestDto.getArticleId()).isNull();
        assertThat(attachmentRequestDto.getLocation()).isNull();

    }

}
