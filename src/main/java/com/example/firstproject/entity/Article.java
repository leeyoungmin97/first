package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity// DB가 해당 객체를 인식가능!(해당 클래스로 테이블을 만든다)
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자를 추가!
@ToString
@Getter
public class    Article {
    @Id //대표값을 지정! LIKE 주민등록번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를  자동생성하게만드는 어노테이션임.
    private Long id;

    @Column //db에서 이해할수있게 컬럼이라는 어노테이션을 붙여줘야함

    private String title;
    @Column //db에서 이해할수있게 컬럼이라는 어노테이션을 붙여줘야함
    private String content;


    public void patch(Article article) {
        if(article.title != null)
            this.title =article.title;
        if(article.content != null)
            this.content = article.content;
    }
}

