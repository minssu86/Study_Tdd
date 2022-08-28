package com.example.tdd_study.domain;

import com.example.tdd_study.dto.AttachmentRequestDto;
import com.example.tdd_study.dto.MockAttachmentDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.*;


public class AttachmentTest {

    @DisplayName("성공 : 입력값 반환")
    @Test
    void CreateAttachmentSuccess() {

        // Given
        AttachmentRequestDto attachmentRequestDto = new MockAttachmentDto(1);
        LocalDateTime createdDatetime = LocalDateTime.now();

        // When
        Attachment attachment = new Attachment(attachmentRequestDto);

        // Then
        assertThat(attachment.getArticleId()).isEqualTo(attachmentRequestDto.getArticleId());
        assertThat(attachment.getLocation()).isEqualTo(attachmentRequestDto.getLocation());
        assertThat(attachment.getCreatedDatetime()).isCloseTo(createdDatetime, within(1, ChronoUnit.SECONDS));

    }

}
