package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // 해당 댓글 엔티티 여러개가,하나의 Article(게시글) 에 연관된다.
    @JoinColumn(name = "article_id")
    //테이블에서 연결된 대상의 정보를 가져야하는데
    //그 대상정보의 컬럼을 뭐라고하겠다?
    //"article_id" 라고 하겠다.
    //article_id 컬럼에 Article의 대표값을 저장!
    private Article article;// 댓글의 부모 게시글을 써준다
    @Column
    private String nickname;
    @Column
    private String body;


    public static Comment createComent(CommentDto dto, Article article) {
        //예외발생
        if(dto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 ID가 없어야 합니다.");
        if(dto.getArticleId() != article.getId())
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 ID가 잘못되었습니다.");
        //엔티티 생성 및 반환
        return  new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        //예외 발생
        if(this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정  실패!" +
                    "잘못된 id 를 입력하였습니다");

        //객체를 갱신
        if(dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if(dto.getBody() != null)
            this.body = dto.getBody();
    }
}
