package com.example.firstproject.api;



import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController //RESTAPI 용 컨트롤러 ! 데이터를 반환!
public class ArticleApiController {
    @Autowired
    private  ArticleRepository articleRepository;

    @Autowired //DI, 생성 객체를 가져와 연결!
    private ArticleService articleService;

    //GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleService.index();
    }

   @GetMapping("/api/articles/{id}")
   public Article show(@PathVariable Long id) {

        return articleService.show(id);
    }

    //POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
        //@RequestBody json으로 작성한것을 dto 에 담기위함


    //PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,
                                         @RequestBody ArticleForm dto) {
       Article updated = articleService.update(id,dto);

       return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated) :
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
    //DELETE

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {

      Article deleted = articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(null) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //트랜잭션 -> 실패 -> 롤백!

    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos) {
       List<Article> createdList  =  articleService.createArticles(dtos);
       return (createdList != null) ?
               ResponseEntity.status(HttpStatus.OK).body(createdList) :
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    }








