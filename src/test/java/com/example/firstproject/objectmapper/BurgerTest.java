package com.example.firstproject.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {

    @Test
    public void 자바_객체를_JSON_으로_변환() throws JsonProcessingException {
        //준비
        List<String> ingredients = Arrays.asList("토마토","통새우 패티","순쇠고기 패티");
        ObjectMapper objectMapper = new ObjectMapper();
        Burger burger = new Burger("맥도날드 슈비버거",5500,ingredients);

        //수행
        String json = objectMapper.writeValueAsString(burger);

        //애상
        String expected = "{\"name\":\"맥도날드 슈비버거\",\"price\":5500,\"ingredients\":[\"토마토\",\"통새우 패티\",\"순쇠고기 패티\"]}";

        //검증
        assertEquals(expected.toString(),json.toString());
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());

    }
    @Test
    public void JSON_을_자바_객체로_변환() throws JsonProcessingException {
        //준비
       ObjectMapper objectMapper = new ObjectMapper();

       /*
       {
       "name" : "맥도널드 슈비버거",
       "price" : 5500,
       "ingredients" :["토마토","통새우 패티","순쇠고기 패티"]
       }
        */
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name","맥도날드 슈비버거");
        objectNode.put("price",5500);


         ArrayNode arrayNode = objectMapper.createArrayNode();
         arrayNode.add("토마토");
        arrayNode.add("통새우 패티");
        arrayNode.add("순쇠고기 패티");
        objectNode.set("ingredients",arrayNode);
        String json = objectNode.toString();
        //수행
      Burger burger = objectMapper.readValue(json,Burger.class);

        //예상
        List<String> ingredients = Arrays.asList("토마토","통새우 패티","순쇠고기 패티");
        Burger burgerdto = new Burger("맥도날드 슈비버거",5500,ingredients);

        //검증
        assertEquals(burgerdto.toString(),burger.toString());
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
        System.out.println(burger.toString());
    }

}