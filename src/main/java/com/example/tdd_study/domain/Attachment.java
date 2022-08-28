package com.example.tdd_study.domain;

import com.example.tdd_study.dto.AttachmentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(length = 255)
    private  String location;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    public Attachment(AttachmentRequestDto attachmentRequestDto) {
        this.articleId = attachmentRequestDto.getArticleId();
        this.location = attachmentRequestDto.getLocation();
        this.createdDatetime = LocalDateTime.now();
    }

}
