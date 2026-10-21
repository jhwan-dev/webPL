package com.example.week05.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloViewController {
    @GetMapping("/hello-view")
    public String helloView(
            @RequestParam(name="name", defaultValue = "학생") String name, Model model) {
//            Model: Controller에서 만든 데이터를 HTML 화면으로 전달하기 위한 객체
        model.addAttribute("name", name);
//            첫번째 name: HTML에서 ${name}으로 꺼내 쓸 이름
//            두번째 name: JAVA 변수, 실제로 선언된 자바 변수이름을 써야함
        return "hello"; // templates/hello.html2
    }
}
