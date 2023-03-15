package com.example.firstproject.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChefTest {
    @Autowired IngredientFactory ingredientFactory;
    //스프링의 IOC 컨테이너로부터 ingredientFactory 을  @Autowired 해서 땡겨오게 명령을했지만
    //가져올수없음 . ingredientFactory 객체가 만들어지지 않은것임.
    // 그럼 이것을 IOC 컨테이너에서 만들수있게 하려면 ? 무엇을해야하나?
    // IngredientFactory 클래스에가서 @Component 를 선언해주면된다.
    @Autowired Chef chef;


    @Test
    void 돈가스_요리하기() {
        //준비
       // IngredientFactory ingredientFactory= new IngredientFactory();
 //       Chef chef = new Chef(ingredientFactory);

        String menu = "돈가스";

        //수행
        String food = chef.cook(menu);

        //예상
        String expected = "한돈 등심으로 만든 돈가스";

        // 검증
        assertEquals(expected.toString(), food.toString());
        System.out.println(food);


    }

    @Test
    void 스테이크_요리하기(){
        //준비
       // IngredientFactory ingredientFactory= new IngredientFactory();

  //      Chef chef = new Chef(ingredientFactory);
        String menu = "스테이크";

        //수행
        String food = chef.cook(menu);

        //예상
        String expected = "한우 꽃등심으로 만든 스테이크";

        // 검증
        assertEquals(expected.toString(), food.toString());
        System.out.println(food);



    }

    @Test
    void 크리스피_치킨_요리하기(){
        //준비
       // IngredientFactory ingredientFactory= new IngredientFactory();

//       Chef chef = new Chef(ingredientFactory);
        String menu = "크리스피 치킨";

        //수행
        String food = chef.cook(menu);

        //예상
        String expected = "국내산 10호 닭으로 만든 크리스피 치킨";

        // 검증
        assertEquals(expected.toString(), food.toString());
        System.out.println(food);

    }

}