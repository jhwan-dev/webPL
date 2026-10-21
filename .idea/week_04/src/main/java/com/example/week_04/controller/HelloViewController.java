package com.example.week_04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloViewController {
    @GetMapping("/hello")
//    url에 hello가 들어오면
    public String hello(){
        return "HELLO";
    }
    @GetMapping("/")
    public String hi(){
        return "HELLO Spring Boot";
    }
    @GetMapping("/welcome")
    public String welcome(
            @RequestParam(name="name", defaultValue = "학생") String name
            //여기서 각각의 name의 의미가 다르다 시험출제
            //앞의 name: @RequestParamd 어노테이션의 속성이름
            //"name": 브라우저가 보내는 요청 파라미터의 이름
            //시험에서는 오류를 내고 그부분을 찾게한다
            //뒤 String name: 자바변수
            ){
        return name+"님 환영합니다";
    }
    @GetMapping("/welcome2")
    public String major(
            @RequestParam(name="yourname") String name2,
            @RequestParam(name="major") String major
    ){
        return name2+"님은 " + major + "과를 선택하셨습니다.";
    }
}
