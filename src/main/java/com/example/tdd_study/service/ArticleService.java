package com.example.tdd_study.service;

import com.example.tdd_study.domain.Article;
import com.example.tdd_study.domain.Attachment;
import com.example.tdd_study.domain.Board;
import com.example.tdd_study.dto.request.ArticleRequestDto;
import com.example.tdd_study.dto.response.ArticleResponseDto;
import com.example.tdd_study.repository.ArticleRepository;
import com.example.tdd_study.repository.AttachmentRepository;
import com.example.tdd_study.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;
    private final AttachmentRepository attachmentRepository;

    // 게시글 등록
    @Transactional
    public ArticleResponseDto create(Integer boardId, ArticleRequestDto articleRequestDto) {
        // 게시판 확인
        Board board = boardRepository.findById(boardId).orElseThrow(
                ()-> new NullPointerException("없는 게시판 입니다")
        );
        // 게시글 등록
        Article article = articleRepository.save(new Article(board, articleRequestDto));
        // 첨부파일 등록
        for (int i = 1; i < 4; i++){
            attachmentRepository.save(new Attachment(article, "location " + (i*boardId)));
        }
        // 가장 처음 업로드된 파일 조회
        Attachment attachment = attachmentRepository.findTopByArticleIdOrderById(article.getId());

        return new ArticleResponseDto(article, attachment);
    }

    // 게시글 목록 조회
    @Transactional(readOnly = true)
    public List<ArticleResponseDto> getArticleList() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();
        for (Article article:articles) {
            Attachment attachment = attachmentRepository.findTopByArticleIdOrderById(article.getId());
            ArticleResponseDto articleResponseDto = new ArticleResponseDto(article, attachment);
            articleResponseDtos.add(articleResponseDto);
        }
        return articleResponseDtos;
    }

    // 게시판 이름으로 게시글 조회
    @Transactional(readOnly = true)
    public List<ArticleResponseDto> getArticleListByBoardName(String boardName) {
        List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();
        List<Board> boards = boardRepository.findByNameContains(boardName);
        List<Article> articles = new ArrayList<>();
        for(Board board : boards){
            articles.addAll(articleRepository.findByBoardId(board.getId()));
        }
        for (Article article:articles) {
            Attachment attachment = attachmentRepository.findTopByArticleIdOrderById(article.getId());
            ArticleResponseDto articleResponseDto = new ArticleResponseDto(article, attachment);
            articleResponseDtos.add(articleResponseDto);
        }
        return articleResponseDtos;
    }

    // 게시글 상세 조회
    @Transactional(readOnly = true)
    public List<ArticleResponseDto> getArticleDetailList() {
        List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();
        List<Article> articles = articleRepository.findAll();
        for (Article article:articles) {
            List<Attachment> attachments = attachmentRepository.findByArticleIdOrderByIdDesc(article.getId());
            ArticleResponseDto articleResponseDto = new ArticleResponseDto(article, attachments);
            articleResponseDtos.add(articleResponseDto);
        }
        return articleResponseDtos;
    }

    // 게시글 삭제
    @Transactional
    public String delete(Integer articleId) {
        attachmentRepository.deleteAllByArticleId(articleId);
        articleRepository.deleteById(articleId);
        return "삭제 성공";
    }

    // 게시글 수정
    @Transactional
    public String update(Integer articleId, ArticleRequestDto articleRequestDto) {
        Article article = articleRepository.findById(articleId).orElseThrow(
                ()-> new NullPointerException("게시글 없음")
        );
        article.update(articleRequestDto);
        return "수정 성공";
    }
}
