package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //접속할 url을 적어주는것임.
    public String niceToMeetYou(Model model){
        model.addAttribute("username","영민");
        return "greetings"; // 템플리츠 안에 그리팅스 머스테치를 찾아서 ->브라우저로 전송!
    }
    @GetMapping("/bye")
    public String bye(Model model){
        model.addAttribute("username","영민");
        return "bye";
    }
}
