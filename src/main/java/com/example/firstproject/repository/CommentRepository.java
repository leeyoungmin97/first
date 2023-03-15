package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Long> {
    //특정 게시글의 모든 댓글조회
    @Query(value =
            "SELECT * " +
                    "FROM comment " +
                    "WHERE article_id = :articleId",nativeQuery = true)
    List<Comment> findByArticleId(@Param("articleId") Long articleId);
    //특정 닉네임의 모든 댓글 조회
    @Query(value = "SELECT * FROM comment WHERE nickname = :nickname",nativeQuery = true)
     List<Comment>findByNickname(@Param("nickname") String nickname);

}
// Jpa리파지토리는
// 페이징처리도 할수있고 솔팅처리도 할수있는 리파지토리이다~
