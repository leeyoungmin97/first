package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@Setter
@AllArgsConstructor // 생성자 정의를 줄여주는 어노테이션
@ToString //투스트링을 안만들어줘도 되는 어노테이션
public class ArticleForm {
    private Long id;
    private String title;
    private String content;
    public Article toEntity() {

        return new Article(id,title,content);
    }


}
