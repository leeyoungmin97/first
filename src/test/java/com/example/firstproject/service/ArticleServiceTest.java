package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest //해당 클래스는 스프링부트와 연동되어 테스팅 된다.
class ArticleServiceTest {
    @Autowired
    private ArticleService articleservice;

    @Test
    @Transactional
    void index() {
        //예상
        Article a = new Article(1L,"가가가가","1111");
        Article b = new Article(2L,"나나나나","2222");
        Article c = new Article(3L,"다다다다","3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));



        //실제
        List<Article> articles  = articleservice.index();


        //예상과 실제 비교
        assertEquals(expected.toString(),articles.toString());

    }

    @Test
    @Transactional
    void show__성공____존재하는_id_입력() {
        Long id = 1L;
        //예상
        Article expected = new Article(id,"가가가가","1111");

        //실제
      Article article = articleservice.show(id);

        //비교
        assertEquals(expected.toString(),article.toString());

    }
    @Test
    @Transactional
    void show__실패__존재하지않는__id_입력() {
        Long id = -1L;
        //예상
        Article expected = null;

        //실제
        Article article = articleservice.show(id);

        //비교
        assertEquals(expected,article);

    }

    @Test
    @Transactional
    void create__성공__title_과_content_만_있는_dto_입력() {
        //예상
        String title ="라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(3L,title,content);


        //실제
         Article article= articleservice.create(dto);

        //비교
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    @Transactional
    void create__실패__id_포함된_dto_입력() {
        //예상
        String title ="라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L,title,content);
        Article expected = null;


        //실제
        Article article= articleservice.create(dto);

        //비교
        assertEquals(expected,article);
    }

    @Test
    @Transactional
    void update_성공_아이디와타이틀과컨텐트가있는_dto_입력() {
        //예상
        Long id = 3L;
        String title = "좆같습니다";
        String content = "시발련아";
        Article expected = new Article(id,title,content);
        ArticleForm dto = new ArticleForm(id,title,content);


        //실제
        Article article = articleservice.update(id,dto);

        //비교
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    @Transactional
    void update_성공_아이디와타이틀만있는_dto_입력() {
        //예상
        Long id = 3L;
        String title = "씨발ㅋㅋ";

        Article expected = new Article(id,title,"3333");
        ArticleForm dto = new ArticleForm(id,title,null);


        //실제
        Article article = articleservice.update(id,dto);


        //비교
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    @Transactional
    void update_성공_존재하지않는아이디의디티오입력() {
        //예상
        Long id = 4L;
        String title = "좆같습니다";
        String content = "시발련아";
        Article expected = null;
        ArticleForm dto = new ArticleForm(id,title,content);


        //실제
        Article article = articleservice.update(id,dto);

        //비교
        assertEquals(expected,article);
    }

    @Test
    @Transactional
    void delete_성공____존재하는_id_입력() {
        //예시
        Long id = 1L;
        Article expected = null;


        //실제
       Article deleted = articleservice.delete(id);

        //비교
        assertEquals(expected,deleted);
    }

    @Test
    void delete_실패____존재하지_않는_id_입력() {
    }
}
