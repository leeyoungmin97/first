package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
    //조회 :댓글 목록
//        List<Comment>comments =commentRepository.findByArticleId(articleId);

    // 변환 : 엔티티 -> dto
//       List<CommentDto> dtos = new ArrayList<CommentDto>(); //일단변수만듬.
//       for( int i = 0; i<comments.size(); i++){
//          Comment c = comments.get(i);
//          CommentDto dto = CommentDto.createCommentDto(c);
//           dtos.add(dto);
//
//       }

    //반환
    return commentRepository.findByArticleId(articleId) // 조회: 댓글 목록
            .stream()
            .map(comment -> CommentDto.createCommentDto(comment))
            //하나하나씩 지금 메소드 적용시켰음 그럼? 이제 콜렉트로 묶어줘야함.

            .collect(Collectors.toList());

       }


       @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {

        //게시글 조회 및 예외 발생
         Article article = articleRepository.findById(articleId)
                   .orElseThrow(()->new IllegalArgumentException("댓글 생성 실패!" +
                           "대상 게시글이 없습니다.")); //만약 없다면 예외를 발생시키겠다.

        //댓글 엔티티 생성
           Comment comment = Comment.createComent(dto,article);

        //댓글 엔티티를 db로 저장
        Comment created  = commentRepository. save(comment);

        //dto로 변경하여 반환
        return  CommentDto.createCommentDto(created);


    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        //댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("그런 댓글" +
                "없습니다."));

        //댓글을 수정
        target.patch(dto);

        //수정 댓글을 db로 갱신
        Comment updated = commentRepository.save(target);

        //dto로 변환 및 반환
        return CommentDto.createCommentDto(updated);

        //null;


    }

    @Transactional
    public CommentDto delete(Long id) {
        //댓글 조회 및 예외 발생
       Comment target  = commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 삭제 실패 대상이없다"));


        //댓글 삭제
        commentRepository.delete(target);

        //삭제 댓글을 dto로 반환
        return CommentDto.createCommentDto(target);

    }
}
