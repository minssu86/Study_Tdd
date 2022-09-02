package com.example.tdd_study.repository;

import com.example.tdd_study.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

    Attachment findTopByArticleIdOrderById(Integer id);

    List<Attachment> findByArticleIdOrderByIdDesc(Integer id);

    void deleteAllByArticleId(Integer articleId);
}
