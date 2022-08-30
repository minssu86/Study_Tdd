package com.example.tdd_study.domain;

import com.example.tdd_study.dto.request.AttachmentRequestDto;
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

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(length = 255)
    private  String location;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    public Attachment (Article article, AttachmentRequestDto attachmentRequestDto) {
        this.article = article;
        this.location = attachmentRequestDto.getLocation();
        this.createdDatetime = LocalDateTime.now();
    }

}
